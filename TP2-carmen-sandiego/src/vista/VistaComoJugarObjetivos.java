package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaComoJugarObjetivos extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaDeInformacion;
	public VistaComoJugarObjetivos(ModeloJuego modelo, Controlador control) {
		String informacion = "El objetivo del juego es seguir al ladron por una serie de ciudades hasta llegar a su escondite";
		this.areaDeInformacion= new JTextArea(informacion);
		areaDeInformacion.setSize(600, 400);
		areaDeInformacion.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(areaDeInformacion,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setSize(300,300);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		areaDeInformacion.setEditable(false);
		setLayout(new BorderLayout());
		add(scroll,BorderLayout.CENTER);
		setVisible(true);
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
