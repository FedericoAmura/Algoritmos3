package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaInformacion extends JPanel implements Observer {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JTextArea areaDeInformacion;
		private JScrollPane scroll;
		//private ModeloJuego modelo;
		public VistaInformacion(ModeloJuego modelo , Controlador control){
			
			
			modelo.addObserver(this);
			
			setLayout(new GridLayout(1,2));
			
			this.areaDeInformacion= new JTextArea("Aca va la informacion relavante del juego");
			areaDeInformacion.setSize(200, 300);
			scroll= new JScrollPane(areaDeInformacion,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			setSize(300,300);
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			areaDeInformacion.setEditable(true);
			add(new VistaInformacionPolicia(modelo,control));
			add(scroll);
			
			setVisible(true);
			
			
		}

		@Override
		public void update(Observable o, Object arg) {
			
		}
}
