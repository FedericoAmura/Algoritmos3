package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaTiempo extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel etiquetaTiempo;
	private JLabel etiquetaCiudad;
	private ModeloJuego modelo;
	private JLabel etiquetaObjetoRobado;
	private JLabel etiquetaRangoPolicial;
	private JLabel etiquetaCantidadArresto;
	private JLabel etiquetaDiaHora;
	private JLabel etiquetaOrdenDeArresto;
	private JLabel etiquetaLadronAtrapado;
	public VistaTiempo(ModeloJuego modelo , Controlador control){
		
		
		this.modelo= modelo;
		modelo.addObserver(this);
		
		etiquetaTiempo= new JLabel("Tiempo Restante:");
	    etiquetaCiudad = new JLabel("Ciudad Actual: ");
		etiquetaObjetoRobado= new JLabel("Objeto Robado:");
		etiquetaRangoPolicial= new JLabel("Rango Policial:");
		etiquetaCantidadArresto= new JLabel("Cantidad Arrestos:");
		etiquetaDiaHora= new JLabel();
		etiquetaOrdenDeArresto= new JLabel("Orden Emitida: ");
		etiquetaLadronAtrapado= new JLabel("Ladron Profugo");
		etiquetaTiempo.setForeground(Color.WHITE);
	    etiquetaCiudad.setForeground(Color.WHITE);
		etiquetaObjetoRobado.setForeground(Color.WHITE);
		etiquetaRangoPolicial.setForeground(Color.WHITE);
		etiquetaCantidadArresto.setForeground(Color.WHITE);
		etiquetaDiaHora.setForeground(Color.WHITE);
		etiquetaOrdenDeArresto.setForeground(Color.RED);
		etiquetaLadronAtrapado.setForeground(Color.RED);
		setLayout(new GridLayout(4,4));
		setSize(200, 100);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(etiquetaTiempo);
		add(etiquetaCiudad);
		add(etiquetaCantidadArresto);
		add(etiquetaRangoPolicial);
		add(etiquetaObjetoRobado);
		add(etiquetaDiaHora);
		add(etiquetaOrdenDeArresto);
		add(etiquetaLadronAtrapado);
		setVisible(true);
		
	}


	@Override
	public void update(Observable o, Object arg) {
		etiquetaTiempo.setText("Tiempo Restante: " + modelo.getTiempoRestante());
		etiquetaCiudad.setText("Ciudad Actual: " + modelo.getCiudadActual());
		etiquetaRangoPolicial.setText("Rango Policial: "+ modelo.getGradoPolicia());
		etiquetaObjetoRobado.setText("Objeto Robado: "+ modelo.getObjetoRobado());
		etiquetaCantidadArresto.setText("Cantidad Arrestos: "+ modelo.getArrestosPolicia());
		etiquetaDiaHora.setText(modelo.getDiaHora());
		etiquetaOrdenDeArresto.setText("Orden Emitida: "+ modelo.ordenDeArrestoStatus());
		
		if(modelo.ladronAtrapado()==true){
				etiquetaLadronAtrapado.setText("LADRON ATRAPADO!!!"); 
				etiquetaLadronAtrapado.setForeground(Color.GREEN);
		}
		
		
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/barraNegra.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
