package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaInformacionDeCiudad extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JTextArea areaDeInformacion;
	private JScrollPane scroll;
	private ModeloJuego modelo;
	public VistaInformacionDeCiudad(ModeloJuego modelo, Controlador control) {
	
				
			this.modelo= modelo;
			modelo.addObserver(this);
			
			setLayout(new BorderLayout());
			
			this.areaDeInformacion= new JTextArea("Aca va la informacion relavante del juego");
			areaDeInformacion.setSize(200, 300);
			areaDeInformacion.setLineWrap(true);
			scroll= new JScrollPane(areaDeInformacion,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			setSize(300,300);
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			areaDeInformacion.setEditable(false);
			add(scroll,BorderLayout.CENTER);
			
			setVisible(true);
					
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.actualilzarInformacionDeCiudad();
		
	}

	private void actualilzarInformacionDeCiudad() {
		this.areaDeInformacion.setText(modelo.getInformacionSobreCiudadActual());
		
	}

}
