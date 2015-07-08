package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.ModeloJuego;
import controlador.Controlador;

public class PanelViajes extends JPanel implements Observer {
	

	private static final long serialVersionUID = 1L;
	private JButton ciudad1;
	private JButton ciudad2;
	private JButton ciudad3;
	private ModeloJuego modelo;
	private JButton ciudad4;
	public PanelViajes(ModeloJuego modelo, Controlador control){
		
		this.modelo=modelo;
		this.modelo.addObserver(this);
		
		this.ciudad1=new JButton("ciudad 1");
		this.ciudad2=new JButton("ciudad 2"); 
		this.ciudad3=new JButton("ciudad 3");
		this.ciudad4=new JButton("ciudad 4");
		ciudad1.addActionListener(control.getListenerBotonViajar());
		ciudad2.addActionListener(control.getListenerBotonViajar());
		ciudad3.addActionListener(control.getListenerBotonViajar());
		ciudad4.addActionListener(control.getListenerBotonViajar());
		add(ciudad1);
		add(ciudad2);
		add(ciudad3);
		add(ciudad4);
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		ciudad1.setText(modelo.getCiudadesDisponible(0));
		ciudad2.setText(modelo.getCiudadesDisponible(1));
		ciudad3.setText(modelo.getCiudadesDisponible(2));
		ciudad4.setText(modelo.getCiudadesDisponible(3));
		
	}
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/barraAzul.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}
}
