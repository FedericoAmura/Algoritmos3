package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaDeJuego;
import vista.VistaDescripcionDelCaso;
import modelo.ModeloJuego;

public class EscuchadorSiguientePartida implements ActionListener {

	private ModeloJuego modelo;
	private Controlador control;
	private VistaDeJuego vista;
	public EscuchadorSiguientePartida(ModeloJuego modelo, Controlador control, VistaDeJuego vista) {
		

		this.modelo=modelo;
		this.control=control;
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		@SuppressWarnings("unused")
		VistaDescripcionDelCaso vistaDeJuego= new VistaDescripcionDelCaso(this.modelo,this.control);
		vista.dispose();
	}

}
