package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelPistasTitulo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel pistasTitulo;
	
	public PanelPistasTitulo(){
	
		pistasTitulo = new JLabel(" .");
		add(pistasTitulo);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/barraPistas.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}

}

