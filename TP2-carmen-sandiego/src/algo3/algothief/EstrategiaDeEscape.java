package algo3.algothief;

import java.util.ArrayList;
import java.util.List;


public class EstrategiaDeEscape {

	public static List<String> crearRutaDeEscape(Mapa unMapa, String ciudadInicial, int cantidadDePaises) {
		
		List<String> ciudadesADevolver = new ArrayList<String>();
		
		ciudadesADevolver.add(ciudadInicial);
		
		String unaCiudad = ciudadInicial;	
		
		for(int i = 0; i < cantidadDePaises; i++) {
			
			List<Ciudad> lista = unMapa.obtenerConexiones(unaCiudad);
			
			int valorAleatorio = (int) Math.floor(Math.random()*lista.size());
			
			while(ciudadesADevolver.contains(lista.get(valorAleatorio).getNombre())) {
				
				valorAleatorio += 1;
				
				if(valorAleatorio == lista.size()) {
					
					valorAleatorio = 0;
				}
			}
			
			ciudadesADevolver.add(lista.get(valorAleatorio).getNombre());
			
			unaCiudad = lista.get(valorAleatorio).getNombre();
			cargarHerida(lista.get(valorAleatorio));
		}
		
		return ciudadesADevolver;
	}
		
	private static void cargarHerida(Ciudad unaCiudad) {
		
		int valorAleatorio = (int) Math.floor(Math.random()*5);
		if(valorAleatorio == 0) {
			
			Herida laHerida = Herida.getHeridaAleatoria();
			unaCiudad.setHerida(laHerida);
		}
		
	}
}