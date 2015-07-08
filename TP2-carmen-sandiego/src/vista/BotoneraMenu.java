package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;
import controlador.EscuchadorIniciarJuego;

public class BotoneraMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton botonJugar;
	private JButton botonCreditos;
	private JButton botonComoJugar;
	
	public BotoneraMenu(ModeloJuego modelo, Controlador control){
		
		botonJugar= new JButton("Jugar");
		botonCreditos= new JButton("Creditos");
		botonComoJugar= new JButton("Como Jugar");
		
		botonJugar.addActionListener(new EscuchadorIniciarJuego(modelo,control));
		add(botonJugar);
		
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
