package algo3.algothief;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class VistaConsola {

	private Juego unJuego;
	
	public VistaConsola(Juego unJuego) {
			
		this.unJuego= unJuego;
	}
		
		public void iniciarJuego() throws SAXException, IOException, ParserConfigurationException, NombreInvalidoException{
			
		
			this.presentacion();
			this.cargarJugador();
			this.mostrarDatosDelPolicia();
			this.presentarCaso();
			this.empezarAJugar();
			
		}
		
		

		private void empezarAJugar() {
			
			barraSeparadora();
			System.out.println("EMPIEZA EL JUEGO");
			this.darCaracteristicasDeCiudad();
			System.out.println("Bueno que queres hacer?  : ");
			this.darOpciones();
		}


		private void darCaracteristicasDeCiudad() {
			Ciudad ciudadActual= unJuego.getPoliciaQueEstaJugando().getCiudadActual();
			
			System.out.println("Tu ciudad Actual es: "+ ciudadActual.getNombre());
			System.out.println("Esta ciudad se caracteriza por : "+ ciudadActual.getDescripcionGeografica());
		}


		private void darOpciones() {
			
			Scanner in= new Scanner (System.in);
			int dato=0;
				
				do{
			
				System.out.print("1- Revisar Pistas , 2-Ver Ciudades Disponibles 3- Viajar 4- Emitir Orden  De Arresto. 0- salir del juego ");
				dato=in.nextInt();
				this.barraSimple();
			
				switch(dato){
					case 1:{
							this.revisarPistas();
							break;}
					case 2:{
							this.verCiudadesDisponibles();
							break;}
					case 3:{
							this.viajar();
							break;}
					case 4:{
							this.emitirOrdenDeArresto();
							break;}
					case 0:{
							this.terminarJuego();
							break;}
						}
			}while(dato!=0);
		}


		private int terminarJuego() {
			System.out.println("Chau!");
			return(0);
			}


		private void emitirOrdenDeArresto() {
			System.out.println("Elegiste Emitir orden de arresto");
		}


		private void viajar() {
			System.out.println("Elegiste Viajar ");
		}

		private void verCiudadesDisponibles() {
			System.out.println("Elegiste Ver ciudades Disponibles ");
		}

		private void revisarPistas() {
			System.out.println("Elegiste Revisar Pistas �a que edificio Deseas entrar?");
			this.mostrarEdificios();
		}

		private void mostrarEdificios() {
			int dato = 0;
			Scanner in= new Scanner (System.in);
			System.out.println("1-Bolsa ");
			System.out.println("2-Mercado");
			System.out.println("3- Museo");
			dato=in.nextInt();
			switch(dato){
			
				case 1:{
					System.out.println("Deberia mostrar una pista de la moneda del pais a donde fue ");
					System.out.println("y restar las horas por entrar aca");
					break;
					}
				
				case 2:{
					System.out.println("Deberia mostrar una pista del pais a donde fue ");
					System.out.println("y restar las horas por entrar aca");
					break;
					}

				case 3:{
					System.out.println("Deberia mostrar una pista  cultural del pais a donde fue");	
					System.out.println("y restar las horas por entrar aca");
					break;
					}
			
				}
		}


		private void barraSimple() {
			System.out.println("---------------------------------------------------------------");
			
		}


		private void presentarCaso() {
			
			try {
				this.unJuego.iniciarCaso();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//inicio el caso para que me cree el ladron y el objeto robado
			this.barraSeparadora();
			System.out.println("Es hora de que empeces a laburar asi que te damos el siguiente caso: ");
			this.descripcionDelCaso();
			this.descripcionDelLadron();
			this.descripcionFinal();
		}


		private void descripcionFinal() {
			System.out.println("Bueno tenes " + TiempoDeJuego.getInstancia().getHorasRestantes() + " hs para perseguir y atrapar al ladron");
			System.out.println("Bon Voyage!!!");
		}


		private void descripcionDelLadron() {
			
			Ladron ladron = unJuego.getLadron();
			System.out.println("El sospechoso visto en la escena es de sexo " + ladron.getSexo());
			
		}


		private void descripcionDelCaso() {
			
			ObjetoRobado objetoRobado= unJuego.getObjetoRobado();
			
			System.out.print("Se afanaron "+ objetoRobado.getNombre());
			System.out.println(" De la ciudad de "+ objetoRobado.getCiudad().getNombre());
		}


		private void presentacion() {
			System.out.println("Bienvenido a Algo ThieF");
			System.out.println("=======================");
			System.out.println();
			
		}


		public void cargarJugador() throws SAXException, IOException, ParserConfigurationException, NombreInvalidoException{
			
			String dato;
			Scanner in= new Scanner (System.in);

			System.out.print("Escriba el nombre del jugador: ");
			dato= in.next();
			this.barraSeparadora();
			System.out.println("Su nombre no existe en nuestra base de datos de la PFA Asi que de onda le creamos un nuevo perfil ");
			//bueno aca por el momento no hay base de datos asi que el juegador va ser siempre nuevo pero
			//sino habria que cargarlo del archivo xml
			this.unJuego.verificarPolicia(dato);//el verificar policia me parece que la tiene que hacer la vista porque al final
												// el juego siempre va terminar creando un policia
		} 
		public void mostrarDatosDelPolicia(){
			
			Policia policia= unJuego.getPoliciaQueEstaJugando();
		
			this.barraSeparadora();
			System.out.println("Estos son sus datos actuales de policia:");
			System.out.println("Nombre: "+ policia.getNombre());
			System.out.println("Rango:"+ policia.getGrado());
			System.out.println("Cantidad De Arrestos: "+ policia.getCantidadArrestos());
			this.barraSeparadora();			
		}
		
		private void barraSeparadora() {
			System.out.println("=========================================================");
		}


			
	
}
