package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaDescripcionDelCaso extends JFrame implements Observer,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonContinuar;
	private ModeloJuego modelo;
	//private Controlador control;
	
	public VistaDescripcionDelCaso(ModeloJuego modelo, Controlador control) {
		
		this.modelo=modelo;
		//this.control=control;
		setSize(600,300);
		setLocation(400, 300);
		this.botonContinuar= new JButton("Continuar");
		setLayout(new BorderLayout());
		modelo.addObserver(this);
		//add(botonContinuar,BorderLayout.SOUTH);
		add(new VistaInformacionDelCaso(modelo,control,this),BorderLayout.CENTER);
		add(new VistaJugador(this.modelo, control),BorderLayout.NORTH);
		botonContinuar.addActionListener(this);	
		setVisible(true);
	
	}
	



	@Override
	public void update(Observable arg0, Object arg1) {

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
