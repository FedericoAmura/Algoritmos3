package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaDescripcionDelCaso;
import modelo.ModeloJuego;

public class EscuchadorIniciarJuego implements ActionListener {

	private ModeloJuego modelo;
	private Controlador control;

	public EscuchadorIniciarJuego(ModeloJuego modelo, Controlador control){
		
		this.modelo=modelo;
		this.control=control;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		@SuppressWarnings("unused")
		VistaDescripcionDelCaso vistaDeJuego= new VistaDescripcionDelCaso(this.modelo,this.control);
				
	}

}
