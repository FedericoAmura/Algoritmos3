package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;
import controlador.EscuchadorPistasBiblioteca;
import controlador.EscuchadorPistasBolsa;
import controlador.EscuchadorPistasPuerto;
import modelo.ModeloJuego;


public class PanelBotoneraPistas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JButton botonBiblioteca;
	private JButton botonMercado;
	private JButton botonPuerto;
	private ModeloJuego modelo;
	
	
	PanelBotoneraPistas(ModeloJuego modelo, Controlador control){
	
			
		this.modelo=modelo;
		this.modelo.addObserver(this);
		
		this.botonBiblioteca=new JButton("Biblioteca");
		this.botonMercado=new JButton("Mercado"); 
		this.botonPuerto=new JButton("Puerto");
		botonBiblioteca.addActionListener(new EscuchadorPistasBiblioteca(modelo));
		botonMercado.addActionListener(new EscuchadorPistasBolsa(modelo));
		botonPuerto.addActionListener(new EscuchadorPistasPuerto(modelo));
		add(botonBiblioteca);
		add(botonMercado);
		add(botonPuerto);
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/barraDeColor.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}
	
	}
