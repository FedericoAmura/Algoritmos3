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

public class VistaComoJugarObtencionDePistas extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaDeInformacion;
	
	public VistaComoJugarObtencionDePistas(ModeloJuego modelo, Controlador control) {
		String informacion = "Para pedir pistas dirigase a la solapa pistas, desde alli ingrese a los edificios para conseguir diferentes pistas." +
				" Pistas entregadas:\n" +
				"Biblioteca: Pistas relacionadas con hechos historicos\n" +
				"Mercado: Pistas relacionadas con la actividad economica\n" +
				"Puerto: Pistas relacionadas con la bandera o idioma";
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