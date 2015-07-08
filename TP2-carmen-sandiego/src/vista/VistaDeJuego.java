
package vista;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.ModeloJuego;
import controlador.Controlador;


public class VistaDeJuego extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private ModeloJuego modelo;
	private VistaJuegoTerminado vistaJuegoTerminado;
	public  VistaDeJuego(ModeloJuego modelo , Controlador control){
		
		super("AlgoThief");
		setResizable(false);
		setLocation(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.modelo= modelo;
		this.modelo.addObserver(this);
		this.vistaJuegoTerminado=new  VistaJuegoTerminado(modelo,control,this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(650,450);
		setLayout(new BorderLayout());
		tabPane= new JTabbedPane();
		tabPane.addTab("Informacion del pais", new VistaInformacionDeCiudad(modelo,control));
		tabPane.addTab("Viajar",new VistaViajar(modelo,control));
		tabPane.addTab("Ciudades Disponibles", new VistaCiudadesDisponibles(modelo,control));
		tabPane.addTab("Pistas",new VistaPistas(modelo,control));
		tabPane.addTab("Orden De Arresto",new VistaOrdenDeArresto(modelo,control));
		tabPane.addTab("Como jugar", new VistaComoJugar(modelo,control));
		
		
		add(new VistaTiempo(modelo,control),BorderLayout.NORTH);
		add(tabPane,BorderLayout.CENTER);
		vistaJuegoTerminado.setVisible(false);
		tabPane.setVisible(true);
		setVisible(true);
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
	
	try {
		if(modelo.getStatus()==true){
				add(vistaJuegoTerminado,BorderLayout.CENTER);
				vistaJuegoTerminado.setVisible(true);
				tabPane.setVisible(false);
		}
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
		
	}
	



}