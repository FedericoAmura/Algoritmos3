package algo3.algothief;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.lang.Math;

public class Juego {
	
	private Policia policia;
	private Ladron ladron;
	private ObjetoRobado objetoRobado;
	private Mapa unMapa;
	private boolean ladronAtrapado;
	
	private static int contadorCaracteristicas;
	
	public Juego() {
		
		try {
			cargarMapa();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.policia = null;
		this.ladron = null;
		this.ladronAtrapado = false;
		TiempoDeJuego.getInstancia().setJuego(this);
	}
	
	private void cargarMapa() throws ParserConfigurationException, SAXException, IOException {
		
		File archivoMapa = new File("src/algo3/algothief/mapa.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		
		doc = dBuilder.parse(archivoMapa);
		doc.getDocumentElement().normalize();
		
		Mapa unMapa = new Mapa();
		
		NodeList ciudades = doc.getElementsByTagName("Ciudad");
		
		for(int i=0; i< ciudades.getLength(); i++) {
			
			Ciudad unaCiudad;
			Element elementoCiudad = (Element) ciudades.item(i);
			String nombreCiudad = elementoCiudad.getAttribute("nombre");
			String descripcionCiudad = elementoCiudad.getAttribute("desc");
			unaCiudad = new Ciudad(nombreCiudad, descripcionCiudad);
			unMapa.agregarCiudad(unaCiudad);
		}
		
		NodeList conexiones = doc.getElementsByTagName("Conexion");
		
		for(int i=0; i< conexiones.getLength(); i++) {
			
			Element elementoConexion = (Element) conexiones.item(i);
			String primerCiudad = elementoConexion.getAttribute("primerCiudad");
			String segundaCiudad = elementoConexion.getAttribute("segundaCiudad");
			int distancia = Integer.parseInt(elementoConexion.getAttribute("distancia"));
			unMapa.agregarConexion(primerCiudad, segundaCiudad, distancia);
		}
		
		this.unMapa = unMapa;
	}
	
	/* Verifica si el nombre del jugador ya existe, crea un policia con los datos. */
	public void verificarPolicia(String nombreJugador) throws SAXException, IOException, ParserConfigurationException, NombreInvalidoException {
		
		if(nombreJugador.equals("")) throw new NombreInvalidoException("Ingrese un nombre valido");
		File archivo = new File("src/algo3/algothief/" + nombreJugador + ".xml");
		if(archivo.exists()) {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc = dBuilder.parse(archivo);
			doc.getDocumentElement().normalize();
			this.policia = Policia.hidratar(doc);
			
		} else {
			
			this.policia = new Policia(nombreJugador);
		}	
		this.policia.setJuego(this);
		this.policia.setMapa(unMapa);
	}
	
	/* Busca un objeto robado y un ladron. */
	public void iniciarCaso() throws SAXException, IOException, ParserConfigurationException {
		
		unMapa.reestablecerCiudades();
		TiempoDeJuego.getInstancia().reset();
		this.ladronAtrapado = false;
		File archivoObjetos = new File("src/algo3/algothief/objetosRobados.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		doc = dBuilder.parse(archivoObjetos);
		doc.getDocumentElement().normalize();
		
		// Aca deberiamos ver como elegir el valor del objeto
		Element objetos = (Element) doc.getElementsByTagName(this.policia.getDificultadObjeto()).item(0);
		int cantidadDePaises = Integer.parseInt(objetos.getAttribute("paises"));
		
		this.cargarObjeto(objetos);
		
		this.ladron = Ladron.getLadronAleatorio();
		this.ladron.setJuego(this);
		
		List<String> rutaDeEscape = EstrategiaDeEscape.crearRutaDeEscape(unMapa, policia.getCiudadActual().getNombre(), cantidadDePaises);
		this.ladron.setRutaDeEscape(rutaDeEscape);
		
		this.avanzarJuego(rutaDeEscape.get(0));
		TiempoDeJuego.getInstancia().sumarHoras(7);
	}
	
	private void cargarObjeto(Element objetos) {
		
		int valorAleatorio = (int) Math.floor(Math.random()*objetos.getElementsByTagName("Objeto").getLength());
		Element objetoRobado = (Element) objetos.getElementsByTagName("Objeto").item(valorAleatorio);
		String nombreObjetoRobado = objetoRobado.getAttribute("nombre");
		String ciudadInicial = objetoRobado.getAttribute("ciudadInicial");
		this.policia.setCiudad(unMapa.getCiudad(ciudadInicial));
		this.objetoRobado = new ObjetoRobado(nombreObjetoRobado, 4, unMapa.getCiudad(ciudadInicial));
	}
	
	public void avanzarJuego(String nombreCiudad) throws ParserConfigurationException, SAXException, IOException {
		if(ladron.estaEnCiudad(nombreCiudad)){
			File archivoPistas = new File("src/algo3/algothief/pistas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			doc = dBuilder.parse(archivoPistas);
			doc.getDocumentElement().normalize();
			Element pistas = (Element) doc.getElementsByTagName(this.policia.getDificultadPista()).item(0);
			cargarPistasSiguiente(pistas);
		}
	}
	
	private void cargarPistasSiguiente(Element pistas) {
		if(!ladron.estaEnUltimaCiudad()){
			this.ladron.avanzar();
			List<String> caracteristicasLadron = this.obtenerCaracteristicasLadron();
			Ciudad unaCiudad = policia.getCiudadActual();
			String ciudadLadron = ladron.getCiudadActual();
			Element pistasCiudad = (Element) pistas.getElementsByTagName(ciudadLadron.replaceAll(" ", "")).item(0);
			
			Element pistaCiudadBolsa = (Element) pistasCiudad.getElementsByTagName("Bolsa").item(0);
			Element pistaCiudadBiblioteca = (Element) pistasCiudad.getElementsByTagName("Biblioteca").item(0);
			Element pistaCiudadPuerto = (Element) pistasCiudad.getElementsByTagName("Puerto").item(0);
			
			String[] pistasACargar = new String[3];
			pistasACargar[0] = (pistaCiudadBolsa.getAttribute("pista"));
			pistasACargar[1] = (pistaCiudadBiblioteca.getAttribute("pista"));
			pistasACargar[2] = (pistaCiudadPuerto.getAttribute("pista"));
			int valorAleatorio = (int) Math.floor(Math.random()*3);
			if(contadorCaracteristicas==caracteristicasLadron.size()) {
				contadorCaracteristicas = 0;
			}
			Element elementoPistaLadron =(Element) pistas.getElementsByTagName(caracteristicasLadron.get(contadorCaracteristicas)).item(0);
			String pistaLadron = elementoPistaLadron.getAttribute("pista");
			pistasACargar[valorAleatorio] += pistaLadron;
			unaCiudad.cargarPistaBolsaOBanco(pistasACargar[0]);
			unaCiudad.cargarPistaBiblioteca(pistasACargar[1]);
			unaCiudad.cargarPistaPuertoOAeropuerto(pistasACargar[2]);
			contadorCaracteristicas++;
		}else {
			
			Ciudad unaCiudad = policia.getCiudadActual();
			String pistaFinal = "Creo que estas cerca de atraparlo";
			unaCiudad.cargarPistaBolsaOBanco(pistaFinal);
			unaCiudad.cargarPistaBiblioteca(pistaFinal);
			unaCiudad.cargarPistaPuertoOAeropuerto(pistaFinal);
		}
	}
	
	private List<String> obtenerCaracteristicasLadron() {
		
		List<String> lista = new ArrayList<String>();
		lista.add(this.ladron.getCabello());
		lista.add(this.ladron.getHobby());
		lista.add(this.ladron.getSenia());
		lista.add(this.ladron.getVehiculo());
		return lista;
	}
	
	public void finalizarCaso(boolean victorioso){
		if (victorioso) {
			
			this.policia.aumentarArrestos();
			this.ladronAtrapado = true;
		}
		// Aca habria que darle la posibilidad de volver a iniciar otro caso o salir de la aplicacion con terminarPartida
	}
	
	public void terminarPartida() throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element policiaSerializado = this.policia.serializar(doc);
		doc.appendChild(policiaSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivoDestino = new File(("src/algo3/algothief/"+ this.policia.getNombre() + ".xml"));
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source, result);
	}

	public Policia getPoliciaQueEstaJugando() {

		return this.policia;
	}

	public ObjetoRobado getObjetoRobado() {
		
		return this.objetoRobado;
	}

	public Ladron getLadron() {

		return this.ladron;
	}
	
	public List<Ciudad> getCiudadesDisponibles(){
		/* No deberia estar. */
		String ciudadActual=this.getPoliciaQueEstaJugando().getCiudadActual().getNombre();
		List<Ciudad> conexiones= this.unMapa.obtenerConexiones(ciudadActual);
		
		return (conexiones);
	}
	
	public Mapa getMapa() {
		
		return this.unMapa;
	}

	public void setLadron(Ladron unLadron) {
		
		this.ladron = unLadron;
		unLadron.setJuego(this);
	}

	public void setPolicia(Policia unPolicia) {
		
		this.policia = unPolicia;
		unPolicia.setJuego(this);
	}
	
	public boolean ladronEsAtrapado() {
		
		return ladronAtrapado;
	}
}
