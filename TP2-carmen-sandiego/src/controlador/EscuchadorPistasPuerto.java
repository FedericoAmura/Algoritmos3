package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloJuego;

public class EscuchadorPistasPuerto implements ActionListener {

	private ModeloJuego modelo;

	public EscuchadorPistasPuerto(ModeloJuego modelo) {
		this.modelo=modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.setPistaActual(modelo.getPistaPuerto()); 
		modelo.ActualizarObservadores();
	}

}
