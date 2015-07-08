package algo3.algothief;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Policia {
	
	private String nombre;
	private int cantidadDeArrestos;
	private GradoPolicial gradoActual;
	private Ciudad ciudadActual;
	private Mapa mapa;
	private Juego unJuego;
	private OrdenDeArresto ordenDeArresto;
	
	public Policia() {}
	
	public Policia(String nombre) {
		
		this.nombre = nombre;
		this.cantidadDeArrestos = 0;
		this.gradoActual = new Novato();
		this.ordenDeArresto = null;
	}
	
	public void setJuego(Juego unJuego) {
		
		this.unJuego = unJuego;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public Element serializar(Document doc){
		
		Element elementoPolicia = doc.createElement("Policia");
	
		elementoPolicia.setAttribute("nombre", this.nombre);
		elementoPolicia.setAttribute("arrestos", Integer.toString(this.cantidadDeArrestos));
		
		return elementoPolicia;
	}
	
	public static Policia hidratar(Document doc) {
		
		Element elementoPolicia = (Element)doc.getElementsByTagName("Policia").item(0);
		
		String nombre = elementoPolicia.getAttribute("nombre");
		int arrestos = Integer.parseInt(elementoPolicia.getAttribute("arrestos"));
		
		Policia nuevoPolicia = new Policia(nombre);
		
		for (int i = 0; i < arrestos; i++) {
			
			nuevoPolicia.aumentarArrestos();
		}
		
		return nuevoPolicia;
	}
	
	public int getCantidadArrestos() {
		
		return cantidadDeArrestos;
	}

	public String getGrado() {
		
		return gradoActual.getNombre();
	}
	
	public void setCiudad(Ciudad ciudad) {
		
		this.ciudadActual = ciudad;
	}
	
	public Ciudad getCiudadActual() {

		return this.ciudadActual;
	}
	
	public void setMapa(Mapa mapa){
	
		this.mapa = mapa;
	}
	
	public void aumentarArrestos() {
		
		cantidadDeArrestos += 1;
		
		if(gradoActual.ascensoDisponible(cantidadDeArrestos)) {
		
			gradoActual = gradoActual.ascender();
		}
	}	

	/*****************************************************************
	 *                    Metodos para jugar.                        *
	 *****************************************************************/
	
	public List<Ciudad> verCiudadesDisponibles() {
	
		return (this.mapa.obtenerConexiones(ciudadActual.getNombre()));
	}
	
	public void viajarACiudad(Ciudad ciudad) {
		
		int distancia = this.mapa.obtenerDistancia(ciudadActual, ciudad);
		
		int horas = this.gradoActual.costoDeViajeEnHoras(distancia);
		
		TiempoDeJuego.getInstancia().sumarHoras(horas);
		
		ciudad.aumentarHorasPorHerida();
		this.setCiudad(ciudad);
		try {
			this.unJuego.avanzarJuego(ciudadActual.getNombre());
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
		
	}
	
	public String getPistaBolsaOBanco() {
		
		this.intentarAtraparLadron();
		return this.ciudadActual.getBolsaOBanco();
	}
	
	public String getPistaBiblioteca() {
		
		this.intentarAtraparLadron();
		return this.ciudadActual.getBiblioteca();
	}
	
	public String getPistaPuertoOAeropuerto() {
		
		this.intentarAtraparLadron();
		return this.ciudadActual.getPuertoOAeropuerto();
	}
	
	private void intentarAtraparLadron() {
		
		if(ordenDeArresto != null) {
			
			unJuego.getLadron().esAtrapado(ciudadActual.getNombre());
		}
	}
	
	public boolean emitirOrdenDeArresto(String sexo, String cabello, String senia, String vehiculo, String hobby) {
		
		OrdenDeArresto ordenDeArresto = new OrdenDeArresto(sexo, cabello, senia, vehiculo, hobby);
		if(ordenDeArresto.compararCon(unJuego.getLadron())){
			
			this.ordenDeArresto = ordenDeArresto;
			return true;
		}
		
		this.ordenDeArresto = null;
		return false;
	}
	
	public String getDificultadObjeto() {
		
		return this.gradoActual.dificultadObjeto();
	}
	
	public String getDificultadPista() {
		
		return this.gradoActual.dificultadPistas();
	}
}

