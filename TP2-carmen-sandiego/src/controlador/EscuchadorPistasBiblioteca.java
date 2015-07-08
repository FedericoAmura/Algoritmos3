package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloJuego;

public class EscuchadorPistasBiblioteca implements ActionListener {

	private ModeloJuego modelo;

	public EscuchadorPistasBiblioteca(ModeloJuego modelo) {
		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.setPistaActual(modelo.getPistaBiblioteca()); 
		modelo.ActualizarObservadores();
	}

}
