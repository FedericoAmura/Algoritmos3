package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaCiudadesDisponibles extends JPanel implements Observer {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JLabel ciudad1;
		private JLabel ciudad2;
		private JLabel ciudad3;
		private JLabel ciudad4;
		private ModeloJuego modelo;
	
	public VistaCiudadesDisponibles(ModeloJuego modelo , Controlador control){
		
		this.modelo=modelo;
		this.modelo.addObserver(this);
		this.ciudad1=new JLabel("ciudad 1");
		this.ciudad2=new JLabel("ciudad 2"); 
		this.ciudad3=new JLabel("ciudad 3");
		this.ciudad4= new JLabel("ciudad 4");
		Font fuente = new Font(Font.SANS_SERIF,Font.BOLD,25);
		ciudad1.setFont(fuente);
		ciudad2.setFont(fuente);
		ciudad3.setFont(fuente);
		ciudad4.setFont(fuente);
		ciudad1.setForeground(Color.WHITE);
		ciudad2.setForeground(Color.WHITE);
		ciudad3.setForeground(Color.WHITE);
		ciudad4.setForeground(Color.WHITE);
		setLayout(new GridLayout(9,1,1,1));
		
		add(ciudad1);
		add(ciudad2);
		add(ciudad3);
		add(ciudad4);
		
		setVisible(true);
		
	
		
	
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		ciudad1.setText("* "+modelo.getCiudadesDisponible(0));
		ciudad2.setText("* "+modelo.getCiudadesDisponible(1));
		ciudad3.setText("* "+modelo.getCiudadesDisponible(2));
		ciudad4.setText("* "+modelo.getCiudadesDisponible(3));

	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/ciudadesDisponibles.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}

}