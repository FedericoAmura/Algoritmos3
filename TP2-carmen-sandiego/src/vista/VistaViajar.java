package vista;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaViajar extends JPanel implements Observer {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private ModeloJuego modelo;
		
	public VistaViajar(ModeloJuego modelo , Controlador control){
		
		this.modelo=modelo;
		this.modelo.addObserver(this);
		
		setLayout(new BorderLayout());
		add(new PanelPlanisferio(),BorderLayout.CENTER);
		add(new PanelViajes(modelo,control),BorderLayout.SOUTH);
		setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
	

	}
	
	
}
