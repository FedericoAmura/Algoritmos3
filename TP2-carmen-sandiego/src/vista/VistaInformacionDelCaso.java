package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.ModeloJuego;
import controlador.Controlador;
import controlador.EscuchadorIniciarVistaDeJuego;

public class VistaInformacionDelCaso extends JPanel implements Observer,ActionListener {

	
	
	private static final long serialVersionUID = 1L;
	private JTextArea areaDeInformacion;
	private JScrollPane scroll;
	private JButton botonContinuar;
	private ModeloJuego modelo;
	//private Controlador control;
	public VistaInformacionDelCaso(ModeloJuego modelo, Controlador control, VistaDescripcionDelCaso vistaDescripcionDelCaso) {
	
							
				this.modelo= modelo;
				//this.control=control;
				modelo.addObserver(this);
				
				setLayout(new BorderLayout());
				this.botonContinuar= new JButton("Continuar");
				this.areaDeInformacion= new JTextArea("Ingrese su nombre y presione enter");
				areaDeInformacion.setSize(200, 300);
				scroll= new JScrollPane(areaDeInformacion,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				setSize(300,300);
				setBorder(BorderFactory.createLineBorder(Color.BLACK));
				areaDeInformacion.setEditable(false);
				add(scroll,BorderLayout.CENTER);
				areaDeInformacion.setVisible(false);
				botonContinuar.addActionListener(new EscuchadorIniciarVistaDeJuego(modelo,control, vistaDescripcionDelCaso));
				botonContinuar.setVisible(false);
				add(botonContinuar,BorderLayout.SOUTH);
				setVisible(true);
			}

	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
	
			areaDeInformacion.setText(modelo.getDescripcionDelRobo());
			areaDeInformacion.setVisible(true);
			botonContinuar.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
