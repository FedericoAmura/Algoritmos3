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

public class VistaComoJugarTiempo extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaDeInformacion;
	public VistaComoJugarTiempo(ModeloJuego modelo, Controlador control) {
		String informacion = "-Entrar a un edificio(1hr la primera vez , 2 hs 2da vez, 3hs 3ra vez).\n" +
				"-Emitir orden de arresto(3 hs).\n" +
				"-Herida con un cuchillo(2 hs).\n" +
				"-Herida por arma de fuego(4 hs).\n" +
				"-Dormir(8 hs por noche)";
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