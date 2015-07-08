package modelo;

import java.io.IOException;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import algo3.algothief.Ciudad;
import algo3.algothief.Juego;
import algo3.algothief.NombreInvalidoException;
import algo3.algothief.Policia;
import algo3.algothief.TiempoDeJuego;

public class ModeloJuego extends Observable{
	
		private Juego unJuego;
		private String pistaActual="Seleccione un edificio para obtener una pista";
		private Boolean ordenDeArrestoEmitida=false;
		
		public ModeloJuego(Juego unJuego){
			
			this.unJuego= unJuego;
			
		}


		public void cargarPolicia(String nombreDelPolicia) throws SAXException, IOException, ParserConfigurationException, NombreInvalidoException {
			this.unJuego.verificarPolicia(nombreDelPolicia);
			unJuego.iniciarCaso();
			mostrarDatosDelPolicia();
		}
		
		public void mostrarDatosDelPolicia(){
			
			Policia policia= unJuego.getPoliciaQueEstaJugando();
			ActualizarObservadores();	
		}
		public void ActualizarObservadores()
		{
			setChanged();
			notifyObservers();		
		}


		public String getNombrePolicia() {
			String texto;
			texto=this.unJuego.getPoliciaQueEstaJugando().getNombre();
			return texto;
		}


		public String getGradoPolicia() {
			String texto;
			texto=this.unJuego.getPoliciaQueEstaJugando().getGrado();
			return texto;
		}


		public int getArrestosPolicia() {
			int cantidad;
			cantidad= this.unJuego.getPoliciaQueEstaJugando().getCantidadArrestos();
			return cantidad;
		}


		public int getTiempoRestante() {
			int restante;
			restante= TiempoDeJuego.getInstancia().getHorasRestantes();
			return restante;
		}
		
		public String getDiaHora(){
			
			String stringADevolver;
			stringADevolver = TiempoDeJuego.getInstancia().getNombreDia();
			stringADevolver += (" " + Integer.toString(TiempoDeJuego.getInstancia().getHoras()) +"hs");
			return stringADevolver;
			
		}


		public String getCiudadActual() {
			String ciudad;
			ciudad= unJuego.getPoliciaQueEstaJugando().getCiudadActual().getNombre();
			
			
			return ciudad;
		}


		public String getObjetoRobado() {
			String objetoRobado;
			
			objetoRobado= unJuego.getObjetoRobado().getNombre();
			return objetoRobado;
		}


		public String getInformacionSobreCiudadActual() {
			
			StringBuilder builder = new StringBuilder();//con esto construyo la informacion que quiero devolver;
			Ciudad ciudadActual;
			ciudadActual= unJuego.getPoliciaQueEstaJugando().getCiudadActual();
			
		
			builder.append(ciudadActual.getNombre()+". ");
			
			builder.append("\n-------------------\n");
			builder.append(ciudadActual.getDescripcionGeografica());
			
			return (builder.toString());
		}

		public String getDescripcionDelRobo() {
			StringBuilder builder = new StringBuilder();
			builder.append("Bienvenido a Algo Thief\n");
			builder.append("=======================\n");
			builder.append("Su perfil fue cargado con exito.\nAcaban de notificar un robo y se lo han asignado a usted.\n");
			builder.append("\nDESCRIPCION DEL CASO\n");
			builder.append("====================\n");
			builder.append("Se robaron "+ unJuego.getObjetoRobado().getNombre());			
			builder.append(" de la ciudad de "+ unJuego.getObjetoRobado().getCiudad().getNombre() +".\n");
			builder.append("El sospechoso visto en la escena es de sexo " + unJuego.getLadron().getSexo()+"\n");
			builder.append("Tiene " + TiempoDeJuego.getInstancia().getHorasRestantes() + " hs para perseguir y atrapar al ladron.\n");
			builder.append("Bon Voyage!!!");
			return builder.toString();
		}


		public String getCiudadesDisponible(int numeroDeCiudad) {
			
			Ciudad unaCiudad= unJuego.getCiudadesDisponibles().get(numeroDeCiudad);
			String ciudadDisponible=(unaCiudad.getNombre() );
			return ciudadDisponible;
		}


		public void viajarA(String ciudadEscuchada) {
			Ciudad ciudad= unJuego.getMapa().getCiudad(ciudadEscuchada);
			
			if(ciudad.getHerida()!=null) {
				JOptionPane.showConfirmDialog(null,ciudad.getHerida().getDescripcion(), "Herido", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
			
			unJuego.getPoliciaQueEstaJugando().viajarACiudad(ciudad);
			this.setPistaActual("Seleccione un edificio para obtener una pista");
			this.ActualizarObservadores();
			
		}


		public String getPistaBiblioteca() {
			String pista= unJuego.getPoliciaQueEstaJugando().getPistaBiblioteca();
			return(pista);
		}


		public String getPistaBolsa() {
			String pista= unJuego.getPoliciaQueEstaJugando().getPistaBolsaOBanco();
			return pista;
		}
		
		
		public String getPistaPuerto() {
			String pista= unJuego.getPoliciaQueEstaJugando().getPistaPuertoOAeropuerto();
			return pista;
		}


		public String getPistaActual() {
			return this.pistaActual;
		}


		public void setPistaActual(String pista) {
			this.pistaActual=pista;
		}


		public void emitirOrdenDeArresto(String sexo,String hobby,String cabello, String senia ,String vehiculo) {
			
			 this.ordenDeArrestoEmitida= unJuego.getPoliciaQueEstaJugando().emitirOrdenDeArresto(sexo, hobby, cabello, senia, vehiculo);
		}


		
		public Boolean ordenDeArrestoStatus() {
		
		
			
			return this.ordenDeArrestoEmitida;
		}


		public boolean ladronAtrapado() {
			
			return unJuego.ladronEsAtrapado();
		}


		public boolean getStatus() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		
			if(this.ladronAtrapado()==true){
				this.unJuego.terminarPartida();
				return true;
				}
			
			if (TiempoDeJuego.getInstancia().getHorasRestantes()<=0){
				
				return true;
			}
			
			return false;
		}
}

