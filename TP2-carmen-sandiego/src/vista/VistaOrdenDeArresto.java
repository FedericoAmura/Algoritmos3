/**
 * 
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;
import controlador.EscuchadorEmitirOrdenDeArresto;

	

public class VistaOrdenDeArresto extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel etiquetaSexo;
	private JLabel etiquetaCabello;
	private JLabel etiquetaHobbie;
	private JLabel etiquetaVehiculo;
	private JLabel etiquetaSenia;
	
	private JComboBox<String> sexo;
	private JComboBox<String> cabello;
	private JComboBox<String> hobbie;
	private JComboBox<String> vehiculo;
	private JComboBox<String> senia;
	
	private JButton emitirOrden;
	
	public VistaOrdenDeArresto(ModeloJuego modelo ,Controlador control){
		
		
		String generico = "------";
		etiquetaSexo= new JLabel("Sexo");
		etiquetaCabello= new JLabel("Cabello");
		etiquetaHobbie= new JLabel("Hobbie");
	    etiquetaVehiculo= new JLabel("Vehiculo");
		etiquetaSenia= new JLabel("Senia");
		
		sexo= new JComboBox<String>();
		sexo.addItem(generico);
		sexo.addItem("Femenino");
		sexo.addItem("Masculino");
		
		cabello= new JComboBox<String>();
		cabello.addItem(generico);
		cabello.addItem("Castanio");
		cabello.addItem("Rubio");
		cabello.addItem("Rojo");
		cabello.addItem("Negro");
		
		hobbie= new JComboBox<String>();
		hobbie.addItem(generico);
		hobbie.addItem("Tenis");
		hobbie.addItem("Musica");
		hobbie.addItem("Alpinismo");
		hobbie.addItem("Paracaidismo");
		hobbie.addItem("Natacion");
		hobbie.addItem("Croquet");
		
		vehiculo= new JComboBox<String>();
		vehiculo.addItem(generico);
		vehiculo.addItem("Descapotable");
		vehiculo.addItem("Limusina");
		vehiculo.addItem("Deportivo");
		vehiculo.addItem("Moto");
		
		senia= new JComboBox<String>();
		senia.addItem(generico);
		senia.addItem("Anillo");
		senia.addItem("Tatuaje");
		senia.addItem("Cicatriz");
		senia.addItem("Joyas");
		
		
		emitirOrden= new JButton("Emitir Orden De Arresto");
		emitirOrden.addActionListener(new EscuchadorEmitirOrdenDeArresto(modelo,sexo,cabello,senia,vehiculo,hobbie));
		setLayout(new GridLayout(7,2,1,1));
		
		add(etiquetaSexo);add(sexo);
		add(etiquetaCabello);add(cabello);
		add(etiquetaSenia);add(senia);
		add(etiquetaVehiculo);add(vehiculo);
		add(etiquetaHobbie);add(hobbie);
		add(emitirOrden);
		setVisible(true);
		
		
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
