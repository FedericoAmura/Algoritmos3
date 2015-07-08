package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import algo3.algothief.NombreInvalidoException;

import modelo.ModeloJuego;


public class Controlador {
	
	private ModeloJuego modelo;

	public Controlador(ModeloJuego modelo){
		
		this.modelo=modelo;
		
	}
	
	
	private class EscucharBotonCargarPolicia implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			try {
				modelo.cargarPolicia(event.getActionCommand());
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NombreInvalidoException e) {
				
			}
		
		} 
	}
		
	public ActionListener getListenerCargarPolicia(){
		
		return(new EscucharBotonCargarPolicia());
	}
	
	private class EscucharBotonViajar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
		
			modelo.viajarA(event.getActionCommand());
		
		}
		
	}
	public ActionListener getListenerBotonViajar() {
		// TODO Auto-generated method stub
		return (new EscucharBotonViajar());
	}
	
	private class EscucharBotonPistasBiblioteca implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			//modelo.getPistaBiblioteca();
			System.out.println(modelo.getPistaBiblioteca());
			
			}
	}
	public ActionListener getListenerBotonPistaBiblioteca() {
		// TODO Auto-generated method stub
		return (new EscucharBotonPistasBiblioteca());
	}
	
	private class EscucharBotonPistasBolsa implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			//modelo.getPistaBiblioteca();
			System.out.println(modelo.getPistaBolsa());
			
			}
	}
	public ActionListener getListenerBotonPistaBolsa() {
		// TODO Auto-generated method stub
		return (new EscucharBotonPistasBolsa());
	}
	
	private class EscucharBotonPistasPuerto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			//modelo.getPistaBiblioteca();
			System.out.println(modelo.getPistaPuerto());
			
			}
	}
	
	public ActionListener getListenerBotonPistaPuerto() {
		// TODO Auto-generated method stub
		return (new EscucharBotonPistasPuerto());
	}
}
