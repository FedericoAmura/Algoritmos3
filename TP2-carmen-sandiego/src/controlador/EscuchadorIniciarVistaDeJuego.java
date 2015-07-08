package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.VistaDeJuego;
import vista.VistaDescripcionDelCaso;
import modelo.ModeloJuego;

public class EscuchadorIniciarVistaDeJuego implements ActionListener {

	private ModeloJuego modelo;
	private Controlador control;
	private VistaDeJuego vistaJuego;
	private VistaDescripcionDelCaso vista;
	
	public EscuchadorIniciarVistaDeJuego(ModeloJuego modelo, Controlador control, VistaDescripcionDelCaso vistaDescripcionDelCaso){
		this.modelo=modelo;
		this.control=control;
		this.vista=vistaDescripcionDelCaso;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.vistaJuego= new VistaDeJuego(modelo,control);
		this.vista.dispose();
		modelo.ActualizarObservadores();
		
	}

}
