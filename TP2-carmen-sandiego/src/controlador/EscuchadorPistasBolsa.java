package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloJuego;

public class EscuchadorPistasBolsa implements ActionListener {

	private ModeloJuego modelo;

	public EscuchadorPistasBolsa(ModeloJuego modelo) {

		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelo.setPistaActual(modelo.getPistaBolsa()); 
		modelo.ActualizarObservadores();

	}

}
