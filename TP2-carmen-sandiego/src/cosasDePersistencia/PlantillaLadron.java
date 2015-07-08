package cosasDePersistencia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class PlantillaLadron {
	
	private String nombre;
	private String sexo;
	private String hobby;
	private String cabello;
	private String senia;
	private String vehiculo;
	
	public PlantillaLadron() {} // Necesario para hidratar.
	
	public PlantillaLadron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.hobby = hobby;
		this.cabello = cabello;
		this.senia = senia;
		this.vehiculo = vehiculo;
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public Node serializar(Document doc) {
		
		Element element = doc.createElement("ladron");
		
		element.setAttribute("nombre", this.nombre);
		element.setAttribute("sexo", this.sexo);
		element.setAttribute("hobby", this.hobby);
		element.setAttribute("cabello", this.cabello);
		element.setAttribute("senia", this.senia);
		element.setAttribute("vehiculo", this.vehiculo);
		
		return element;
	}

	public static PlantillaLadron hidratar(Node elementoLadron) {
		
		PlantillaLadron nuevoLadron = new PlantillaLadron();
		
		nuevoLadron.nombre = ((Element)elementoLadron).getAttribute("nombre");
		nuevoLadron.sexo = ((Element)elementoLadron).getAttribute("sexo");
		nuevoLadron.hobby = ((Element)elementoLadron).getAttribute("hobby");
		nuevoLadron.cabello = ((Element)elementoLadron).getAttribute("cabello");
		nuevoLadron.senia = ((Element)elementoLadron).getAttribute("senia");
		nuevoLadron.vehiculo = ((Element)elementoLadron).getAttribute("vehiculo");
		
		return nuevoLadron;
	}
}
