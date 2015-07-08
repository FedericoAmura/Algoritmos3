package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaPistas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public VistaPistas(ModeloJuego modelo , Controlador control){
		
		setLayout(new BorderLayout());
		
		add(new PanelPistasTitulo(),BorderLayout.NORTH);
		add(new PanelMostrarPistas(modelo,control),BorderLayout.CENTER);
		add(new PanelBotoneraPistas(modelo,control),BorderLayout.SOUTH);
	
	}
	
	
	


}
