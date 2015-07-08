package vista;



import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controlador.Controlador;
import modelo.ModeloJuego;

public class VentanaPrincipal extends JFrame implements Observer{

	private ModeloJuego modelo;
	private Clip clip1;
	@SuppressWarnings("unused")
	private boolean playing;

	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal(ModeloJuego modelo , Controlador control){
		
		this.modelo=modelo;
		this.modelo.addObserver(this);

		setTitle("AlgoThief v1.3");	
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(525,475);
		setLocation(400,300);
		setLayout(new BorderLayout());
		
		add(new VistaImagenMenu(),BorderLayout.CENTER);
		add(new BotoneraMenu(modelo,control),BorderLayout.SOUTH);
		
		
			
		setResizable(false);
		setVisible(true);
		 
		try {
			
	         // Open an audio input stream.
	        File soundFile = new File("src/vista/sonido/theme.mid");
	        AudioInputStream stream = AudioSystem.getAudioInputStream(soundFile);
	        // Get a sound clip resource.
	         this.clip1 = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip1.open(stream);
	         this.playing = true;
	         clip1.loop(Clip.LOOP_CONTINUOUSLY);
	         
	    }
		catch (UnsupportedAudioFileException e) { 
			e.printStackTrace(); } 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	
		setVisible(false);
		clip1.stop();
	
	}

}
