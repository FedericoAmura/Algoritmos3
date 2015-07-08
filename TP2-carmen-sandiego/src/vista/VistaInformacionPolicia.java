package vista;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaInformacionPolicia extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JLabel nombrePolicia;
	private JLabel gradoPolicia;
	private JLabel arrestosPolicia;
	private ModeloJuego modelo;
	
	public VistaInformacionPolicia(ModeloJuego modelo , Controlador control){
		
		
		this.modelo= modelo;
		modelo.addObserver(this);
		nombrePolicia= new JLabel("Nombre:");
		gradoPolicia= new JLabel("Grado:");
		arrestosPolicia= new JLabel("C.Arrestos:");
		
		setLayout(new GridLayout(3,1,2,2));
		add(nombrePolicia);
		add(gradoPolicia);
		add(arrestosPolicia);
		
		
		setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		nombrePolicia.setText("Nombre: "+ modelo.getNombrePolicia());
		gradoPolicia.setText("Grado: "+ modelo.getGradoPolicia());
		arrestosPolicia.setText("C.Arrestos: " + modelo.getArrestosPolicia());
		
	}
	
}
