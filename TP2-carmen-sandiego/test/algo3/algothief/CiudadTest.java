package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CiudadTest {
	
	private Ciudad miCiudad;
	private Ciudad otraCiudad;
	private String pista;
	
	@Before
	public void setUp() {
		
		miCiudad = new Ciudad("Roma", "descripcionRoma");
		otraCiudad = new Ciudad("Moscu", "descripcionMoscu");
		miCiudad.cargarPistaBolsaOBanco("Es un pais con mucha inflacion");
		miCiudad.cargarPistaBiblioteca("Se lee mucho sobre futbol");
		miCiudad.cargarPistaPuertoOAeropuerto("Viajo por la empresa Aerolineas ...");
	}
	
	@Test
	public void creoUnaCiudad() {
		
		Assert.assertEquals("Roma", miCiudad.getNombre());
		Assert.assertEquals("descripcionRoma", miCiudad.getDescripcionGeografica());
	}
	
	@Test
	public void cargoPistasAUnaCiudad() {
		
		Assert.assertEquals("Es un pais con mucha inflacion", miCiudad.getBolsaOBanco());
		Assert.assertEquals("Se lee mucho sobre futbol", miCiudad.getBiblioteca());
		Assert.assertEquals("Viajo por la empresa Aerolineas ...", miCiudad.getPuertoOAeropuerto());
	}
	
	@Test
	public void seAdelantaElRelojCorrectamenteConCadaVisita() {
				
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		
		Assert.assertEquals(0, instancia1.getHoras());
		pista = miCiudad.getBiblioteca();
		Assert.assertEquals(1, instancia1.getHoras());
		pista = miCiudad.getBolsaOBanco();
		Assert.assertEquals(3, instancia1.getHoras());
		pista = miCiudad.getPuertoOAeropuerto();
		Assert.assertEquals("Viajo por la empresa Aerolineas ...", pista); //solo para que no se queje el compilador de que no usamos pista
		Assert.assertEquals(6, instancia1.getHoras());
		pista = miCiudad.getBolsaOBanco();
		Assert.assertEquals(9, instancia1.getHoras()); //Despues de visitar por tercera vez ya no sigue aumentando
	}
	
	@Test
	public void ciudadAumentaCorrectamenteElTiempoDependiendoDelTipoDeHerida() {
		
		TiempoDeJuego.getInstancia().reset();
		miCiudad.aumentarHorasPorHerida();
		Assert.assertEquals(0, TiempoDeJuego.getInstancia().getHoras());
		miCiudad.setHerida(Herida.heridaPorCuchillo());
		miCiudad.aumentarHorasPorHerida();
		Assert.assertEquals(2, TiempoDeJuego.getInstancia().getHoras());
		miCiudad.setHerida(Herida.heridaPorArma());
		miCiudad.aumentarHorasPorHerida();
		Assert.assertEquals(6, TiempoDeJuego.getInstancia().getHoras());
	}
}
