package cosasDePersistencia;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ContenedorDeLadrones {
	
	private List<PlantillaLadron> listaConLadrones = new ArrayList<PlantillaLadron>();
	
	public ContenedorDeLadrones() {} // Constructor sin parametros, es necesario para hidratar.
	
	public void agregarLadron(PlantillaLadron ladron) {
		
		this.listaConLadrones.add(ladron);
	}
	
	public Element serializar(Document doc) {
	
		Element elementoLadrones = doc.createElement("ladrones");
		
		for (PlantillaLadron ladron : this.listaConLadrones) {
		
			elementoLadrones.appendChild(ladron.serializar(doc));
		}
		
		return elementoLadrones;
	}
	
	public static ContenedorDeLadrones hidratar(Document doc) {
		
		ContenedorDeLadrones contenedor = new ContenedorDeLadrones();
		
		Element elementosLadron = (Element)doc.getElementsByTagName("ladrones").item(0);
		
		for(int i = 0; i < elementosLadron.getChildNodes().getLength(); i++) {
			
			PlantillaLadron ladron = PlantillaLadron.hidratar(elementosLadron.getChildNodes().item(i));
			
			contenedor.agregarLadron(ladron);
		}
		
		return contenedor;
	}
	
	public int getCantidadDeLadrones() {
		
		return this.listaConLadrones.size();
	}
	
	public PlantillaLadron getLadron(int numero) {
		
		return this.listaConLadrones.get(numero);
	}
}
