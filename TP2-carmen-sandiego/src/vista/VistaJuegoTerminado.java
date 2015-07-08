package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;
import controlador.EscuchadorIniciarJuego;
import controlador.EscuchadorIniciarVistaDeJuego;
import controlador.EscuchadorSiguientePartida;

public class VistaJuegoTerminado extends JPanel {

		private JLabel terminado;
		private JButton botonProximoCaso;
	public VistaJuegoTerminado(ModeloJuego modelo, Controlador control, VistaDeJuego vista) {
		
		this.terminado= new JLabel("JUEGO TERMINADO");
		this.botonProximoCaso= new JButton("Proximo Caso");
		setLayout(new BorderLayout());
		
		//botonProximoCaso.addActionListener(new EscuchadorIniciarVistaDeJuego(modelo, control));
		botonProximoCaso.addActionListener(new EscuchadorSiguientePartida(modelo,control, vista));
		add(terminado,BorderLayout.CENTER);
		add(botonProximoCaso,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	
}
