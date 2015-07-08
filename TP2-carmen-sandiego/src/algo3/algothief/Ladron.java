package algo3.algothief;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.lang.Math;

public class Ladron extends CaracteristicasLadron {
	
	private List<String> ciudadesDeEscape; // = new ArrayList<String>();
	private Juego elJuego;
	private String nombre;
	private int ciudadActual;
	
	public Ladron(String nombre, String sexo, String cabello, String senia, String vehiculo, String hobby) {
		
		this.nombre = nombre;
		this.cabello = cabello;
		this.sexo = sexo;
		this.vehiculo = vehiculo;
		this.hobby = hobby;
		this.senia = senia;
		this.ciudadActual = 0;
		
		ciudadesDeEscape = new ArrayList<String>();		
	}
	
	public Ladron() {} /* Constructor sin parametros, necesario para hidratar. */ 
	
	public void setJuego(Juego unJuego) {
		
		this.elJuego = unJuego;
	}
	
	public void setRutaDeEscape(List<String> ciudades) {
		
		this.ciudadesDeEscape = ciudades;
	}
	
	public boolean pasoPorCiudad(String nombre) {
		
		return (this.ciudadesDeEscape.contains(nombre));
	}	
	
	public boolean ultimaCiudad(String nombreCiudad){
		
		return(nombreCiudad.equals(ciudadesDeEscape.get(ciudadesDeEscape.size()-1)));
	}
	
	public void esAtrapado(String nombreCiudad) {
		
		if(nombreCiudad.equals(ciudadesDeEscape.get(ciudadActual))) {
			
			this.elJuego.finalizarCaso(true);
		}
	}
	
	public static Ladron hidratar(Element elementoLadron) {
		
		Ladron nuevoLadron = new Ladron();
		
		nuevoLadron.nombre = elementoLadron.getAttribute("nombre");
		nuevoLadron.sexo = elementoLadron.getAttribute("sexo");
		nuevoLadron.hobby = elementoLadron.getAttribute("hobby");
		nuevoLadron.cabello = elementoLadron.getAttribute("cabello");
		nuevoLadron.senia = elementoLadron.getAttribute("senia");
		nuevoLadron.vehiculo = elementoLadron.getAttribute("vehiculo");
		
		nuevoLadron.ciudadesDeEscape = new ArrayList<String>();
		
		return nuevoLadron;
	}
	
	/* Devuelve un ladron en forma aleatorio del archivo. */
	public static Ladron getLadronAleatorio() throws SAXException, IOException, ParserConfigurationException {
		
		File archivoLadrones = new File("src/algo3/algothief/ladrones.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		doc = db.parse(archivoLadrones);
		doc.getDocumentElement().normalize();
		
		int numeroAleatorio = (int) Math.floor(Math.random()*13);
		
		Element elementoLadron = (Element)doc.getElementsByTagName("ladron").item(numeroAleatorio);
		
		Ladron unLadron = Ladron.hidratar(elementoLadron);
		
		return unLadron;
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public String getCabello() {
		
		return this.cabello;
	}
	
	public String getSexo() {
		
		return this.sexo;
	}
	
	public String getVehiculo() {
		
		return this.vehiculo;
	}
	
	public String getHobby() {
		
		return this.hobby;
	}
	
	public String getSenia() {
		
		return this.senia;
	}

	public void avanzar() {
		
		ciudadActual++;
	}

	public String getCiudadActual() {
		
		return ciudadesDeEscape.get(ciudadActual);
	}

	public boolean estaEnUltimaCiudad() {
		
		return(ciudadActual==ciudadesDeEscape.size()-1);
	}

	public boolean estaEnCiudad(String nombreCiudad) {
		
		return ciudadesDeEscape.get(ciudadActual).equals(nombreCiudad);
	}
}
