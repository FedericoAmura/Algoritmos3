package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import modelo.ModeloJuego;
import controlador.Controlador;

public class VistaComoJugar extends JPanel implements Observer {

	private JTextArea areaDeInformacion;
	private JScrollPane scroll;
	private ModeloJuego modelo;
	private JTabbedPane tabPane;
	
	public VistaComoJugar(ModeloJuego modelo, Controlador control) {
	
				
			this.modelo= modelo;
			modelo.addObserver(this);
			this.tabPane = new JTabbedPane();
			tabPane.addTab("Objetivos", new VistaComoJugarObjetivos(modelo, control));
			tabPane.addTab("Obtencion de pistas", new VistaComoJugarObtencionDePistas(modelo, control));
			tabPane.addTab("Tiempo", new VistaComoJugarTiempo(modelo, control));
			setLayout(new BorderLayout());
			add(tabPane,BorderLayout.CENTER);
			tabPane.setVisible(true);
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}
