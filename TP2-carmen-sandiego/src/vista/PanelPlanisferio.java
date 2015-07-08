package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPlanisferio extends JPanel {

	private static final long serialVersionUID = 1L;
	public PanelPlanisferio(){
		
	}
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/planisferio.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}
}
