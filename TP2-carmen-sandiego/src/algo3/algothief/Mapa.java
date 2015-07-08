package algo3.algothief;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Mapa {
	
	private Grafo<String, Integer> mapa;
	private HashMap<String ,Ciudad> ciudades;
	
	public Mapa() {
		this.mapa = new Grafo<String, Integer>();
		this.ciudades = new HashMap<String, Ciudad>();
	}
	
	public void agregarCiudad(Ciudad unaCiudad) {
		this.mapa.agregarVertice(unaCiudad.getNombre());
		this.ciudades.put(unaCiudad.getNombre(), unaCiudad);
	}
	
	public Ciudad getCiudad(String nombreCiudad) {
		
		return ciudades.get(nombreCiudad);
	}
	
	public void agregarConexion(String nombreCiudad, String nombreOtraCiudad, int distancia){
		this.mapa.agregarArista(nombreCiudad, nombreOtraCiudad, distancia);
	}
	
	public int obtenerDistancia(Ciudad unaCiudad, Ciudad otraCiudad) {
		
		return (this.mapa.obtenerPeso(unaCiudad.getNombre(), otraCiudad.getNombre()));
	}
	
	public List<Ciudad> obtenerConexiones(String unaCiudad) {
		
		List<Ciudad> conexiones = new ArrayList<Ciudad>();
		
		Set<String> ciudadesAdyacentes = mapa.listarAristas(unaCiudad);
		
		for(String ciudad : ciudadesAdyacentes) {
			
			conexiones.add(this.ciudades.get(ciudad));
		}
		
		return conexiones;
	}

	public void reestablecerCiudades() {
		Set<String> ciudadesAReestablecer = ciudades.keySet();
		for(String nombreCiudad : ciudadesAReestablecer) {
			ciudades.get(nombreCiudad).reestablecerPistas();
			ciudades.get(nombreCiudad).reestablecerHeridas();
		}
	}
}
