package vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.Controlador;
import modelo.ModeloJuego;

public class PanelMostrarPistas extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	private JTextArea mostrarPistas;
	private ModeloJuego modelo;
	
	public PanelMostrarPistas(ModeloJuego modelo, Controlador control){
		
		this.modelo=modelo;
		modelo.addObserver(this);
		mostrarPistas = new JTextArea();
		mostrarPistas.setText("Seleccione la Pista Que Desea Obtener");
		add(mostrarPistas);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		mostrarPistas.setText(modelo.getPistaActual());
	}

}
