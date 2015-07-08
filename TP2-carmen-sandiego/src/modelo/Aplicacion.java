package modelo;

import controlador.Controlador;
import vista.VentanaPrincipal;
import algo3.algothief.Juego;

public class Aplicacion {
	public static void main(String[] args) {
	
		Juego unJuego= new Juego();
		ModeloJuego modelo= new ModeloJuego(unJuego);
		Controlador control= new Controlador(modelo);
	
		@SuppressWarnings("unused")
		VentanaPrincipal ventanaPrincipal= new VentanaPrincipal(modelo,control);
		
	}
}
