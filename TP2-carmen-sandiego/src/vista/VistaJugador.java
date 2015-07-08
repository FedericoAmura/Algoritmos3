package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;
import controlador.EscuchadorIniciarJuego;
import modelo.ModeloJuego;

public class VistaJugador extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JLabel nombre;
	private JTextField ingresarNombre;
	private JButton cargarPolicia;
	private JLabel texto;
	private ModeloJuego modelo;

	
	public VistaJugador(ModeloJuego modelo , Controlador control){
		
		this.modelo=modelo;
		this.modelo.addObserver(this);
		this.nombre= new JLabel("Nombre de Jugador");
		this.ingresarNombre= new JTextField(15);
		this.texto= new JLabel("Ingresar el nombre y presionar enter");
		this.cargarPolicia= new JButton("Cargar/Crear");
		Font fuente = new Font(Font.SANS_SERIF,Font.BOLD,12);
		setSize(800,800);		
		cargarPolicia.addActionListener(new EscuchadorIniciarJuego(modelo,control));
		ingresarNombre.addActionListener(control.getListenerCargarPolicia());
	
		texto.setFont(fuente);
		ingresarNombre.setFont(fuente);
		texto.setForeground(Color.WHITE);
		nombre.setFont(fuente);
		nombre.setForeground(Color.WHITE);
		add(nombre);
		add(ingresarNombre);
		add(texto);
		
		setVisible(true);
	}
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/vista/imagenes/barraDeColor.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}
	@Override
	public void update(Observable o, Object arg) {
		setVisible(false);
		
		
	}
	
	
}
