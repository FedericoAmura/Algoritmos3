package algo3.algothief;

import java.io.IOException;
import java.util.List;

/*import junit.framework.Assert;*/




import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class IntegracionTest {
	
	private Mapa unMapa;
	private Policia unPolicia;
	private Ladron unLadron;
	private ObjetoRobado unObjeto;
	private Ciudad ciudadInicial;
	private Ciudad ciudadAdyacente1;
	private Ciudad ciudadAdyacente2;
	private Ciudad ciudadAdyacente3;
	private Juego unJuego;

	private Ciudad ciudadAdyacenteDespues;
	
	@Before
	public void setUp() {
	
		ciudadInicial = new Ciudad("Ciudad Donde Arranca", "descripcion");
		ciudadInicial.cargarPistaBolsaOBanco("El dolar vale mucho.");
		ciudadInicial.cargarPistaBiblioteca("Leyo acerca del 4-4-2.");
		ciudadInicial.cargarPistaPuertoOAeropuerto("Hablaban castellano");
		
		ciudadAdyacente1 = new Ciudad("Bs As", "descripcion");
		ciudadAdyacente2 = new Ciudad("Lima", "descripcion");
		ciudadAdyacente3 = new Ciudad("Roma", "descripcion");
		ciudadAdyacenteDespues = new Ciudad("Moscu", "descripcion");
		
		unMapa = new Mapa();
		unMapa.agregarCiudad(ciudadInicial);
		unMapa.agregarCiudad(ciudadAdyacente1);
		unMapa.agregarCiudad(ciudadAdyacente2);
		unMapa.agregarCiudad(ciudadAdyacente3);
		unMapa.agregarCiudad(ciudadAdyacenteDespues);
		unMapa.agregarConexion(ciudadInicial.getNombre(), ciudadAdyacente1.getNombre(), 3000);
		unMapa.agregarConexion(ciudadInicial.getNombre(), ciudadAdyacente2.getNombre(), 500);
		unMapa.agregarConexion(ciudadInicial.getNombre(), ciudadAdyacente3.getNombre(), 1500);
		unMapa.agregarConexion(ciudadAdyacente1.getNombre(), ciudadAdyacenteDespues.getNombre(), 1000);
		
		unLadron = new Ladron("Terminator", "Morocho", "Robot", "Moto", "Matar a John Connor", "Lentes");
		unJuego = new Juego();
		unPolicia = new Policia("robocop");
		unLadron.setRutaDeEscape(EstrategiaDeEscape.crearRutaDeEscape(unMapa, ciudadInicial.getNombre(), 1));
		unPolicia.setMapa(unMapa);
		unPolicia.setCiudad(ciudadInicial);
		unPolicia.setJuego(unJuego);
		unJuego.setPolicia(unPolicia);
		unJuego.setLadron(unLadron);
		
		
		unObjeto = new ObjetoRobado("Baterias", 4, ciudadInicial);
	}

	@Test
	public void viajarDeUnPaisAOtroVisitadoPorElLadronTest() {
		
		List<Ciudad> ciudades = unPolicia.verCiudadesDisponibles();
		
		Assert.assertEquals(unPolicia.getCiudadActual().getNombre(),"Ciudad Donde Arranca");
		Assert.assertEquals(false, ciudades.contains(ciudadInicial));
		Assert.assertEquals(true, ciudades.contains(ciudadAdyacente1));
		Assert.assertEquals(true, ciudades.contains(ciudadAdyacente2));
		Assert.assertEquals(true, ciudades.contains(ciudadAdyacente3));
		Assert.assertEquals(false, ciudades.contains(ciudadAdyacenteDespues));
		
		unPolicia.viajarACiudad(ciudadAdyacente1);

		Assert.assertEquals(ciudadAdyacente1.getNombre(), unPolicia.getCiudadActual().getNombre());
		
		ciudades = unPolicia.verCiudadesDisponibles();
		
		Assert.assertEquals(true, ciudades.contains(ciudadAdyacenteDespues));					
	}

	@Test
	public void ViajarAUnPaisCuestaDistintoTiempoParaDistintosGrados() {
		
		//ahora viajo a la ciudad que quiero y se tienen que sumar las horas dependiendo del tipo de policia que es
	
		TiempoDeJuego.getInstancia().reset();
		
		unPolicia.viajarACiudad(ciudadAdyacente1);
		
		Assert.assertEquals(3, TiempoDeJuego.getInstancia().getHoras());
	}

	@Test
	public void elPoliciaAtrapaAlLadron(){
		
		//Assert.assertTrue(unLadron.esAtrapado(unPolicia.emitirOrdenDeArresto("Robot", "Matar a John Connor", "Morocho", "Lentes", "Moto")));
	}
	
	@Test
	public void cargarPoliciaYJugar() {
		
		/* Creo una instancia de la clase juego. 
		 * Juego miJuego = new Juego(); muestra pantalla inicial.
		 * miJuego.verificarPolicia(nombre); 
		 * miJuego.iniciarCaso(); busca el objeto robado y el ladron.
		 * Policia miPolicia = miJuego.getPoliciaQueEstaJugando();
		 * */
		
		/* Esto debe hacerse en iniciar caso, empieza a las 7hs.********** */
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego.getInstancia().sumarHoras(7); 
		/* ***************************************************** */
		
		Assert.assertEquals(7, TiempoDeJuego.getInstancia().getHoras()); 
		
		/* Esto esta hardcodeado. **************************************** */
		Ciudad ciudadDeOrigen = new Ciudad("Buenos Aires", "descripcion");
		
		/* Cargo las pistas. */
		ciudadDeOrigen.cargarPistaBolsaOBanco("El dolar vale mucho.");
		ciudadDeOrigen.cargarPistaBiblioteca("Leyo acerca del 4-4-2.");
		ciudadDeOrigen.cargarPistaPuertoOAeropuerto("Hablaban castellano");
		
		Policia miPolicia = new Policia("Agustina");
		
		miPolicia.setCiudad(ciudadDeOrigen);
		/* *************************************************************** */
		
		/* Pido las pistas y verifico el tiempo transcurrido. */
		
		miPolicia.getPistaBolsaOBanco();
		Assert.assertEquals(8, TiempoDeJuego.getInstancia().getHoras());
		miPolicia.getPistaBiblioteca();
		Assert.assertEquals(10, TiempoDeJuego.getInstancia().getHoras());
		miPolicia.getPistaPuertoOAeropuerto();
		Assert.assertEquals(13, TiempoDeJuego.getInstancia().getHoras());
		
		/* Ver las ciudades disponibles. */
		
		Mapa miMapa = new Mapa();
		
		Ciudad ciudadAdyacentePrimera = new Ciudad("Roma", "descripcion");
		Ciudad ciudadAdyacenteSegunda = new Ciudad("Lima", "descripcion");
		Ciudad ciudadAdyacenteTercera = new Ciudad("Shangai", "descripcion");
		
		miMapa.agregarCiudad(ciudadDeOrigen);
		miMapa.agregarCiudad(ciudadAdyacentePrimera);
		miMapa.agregarCiudad(ciudadAdyacenteSegunda);
		miMapa.agregarCiudad(ciudadAdyacenteTercera);
		
		miMapa.agregarConexion(ciudadDeOrigen.getNombre(), ciudadAdyacentePrimera.getNombre(), 2000);
		miMapa.agregarConexion(ciudadDeOrigen.getNombre(), ciudadAdyacenteSegunda.getNombre(), 4000);
		miMapa.agregarConexion(ciudadDeOrigen.getNombre(), ciudadAdyacenteTercera.getNombre(), 6500);
		
		miPolicia.setMapa(miMapa);
		
		List<Ciudad> ciudadesDisponibles = miPolicia.verCiudadesDisponibles();
		Assert.assertEquals(13, TiempoDeJuego.getInstancia().getHoras());
		
		Assert.assertEquals(true, ciudadesDisponibles.contains(ciudadAdyacentePrimera));
		Assert.assertEquals(true, ciudadesDisponibles.contains(ciudadAdyacenteSegunda));
		Assert.assertEquals(true, ciudadesDisponibles.contains(ciudadAdyacenteTercera));
		Assert.assertEquals(3, ciudadesDisponibles.size());
		
	}
	
	@Test
	public void probarLosLadrones() throws SAXException, IOException, ParserConfigurationException {
		
		Ladron miLadron = Ladron.getLadronAleatorio(); 
		
		System.out.println(miLadron.getNombre());
		System.out.println(miLadron.getCabello());
		System.out.println(miLadron.getHobby());
		System.out.println(miLadron.getSenia());
		System.out.println(miLadron.getSexo());
		System.out.println(miLadron.getVehiculo());
	}
}
