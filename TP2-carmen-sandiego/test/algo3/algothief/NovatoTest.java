package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NovatoTest {
	private Novato unNovato;
	
	@Before
	public void setUp(){
		
		this.unNovato = new Novato();
	}

	@Test
	public void NovatoVelocidadTest(){
		
		Assert.assertEquals(3, unNovato.costoDeViajeEnHoras(2500));
	}
	
	@Test
	public void NovatoNoDeberiaPoderAscenderConMenosDe5Arrestos(){
		
		Assert.assertEquals(false, unNovato.ascensoDisponible(4));
	}
	
	@Test
	public void NovatoDeberiaPoderAscenderCon5Arrestos(){
		
		Assert.assertEquals(true, unNovato.ascensoDisponible(5));
	}
	
	@Test
	public void NovatoAlAscenderDeberiaDevolverUnDetective(){
		
		Assert.assertEquals(Detective.class, unNovato.ascender().getClass());
	}
	
	@Test
	public void NovatoDeberiaDevolverNombreCorrespondiente(){
		
		Assert.assertEquals("Novato", unNovato.getNombre());
	}
	
	@Test
	public void dificultadObjetoDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Comun", unNovato.dificultadObjeto());
	}
	
	@Test
	public void dificultadPistaDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Facil", unNovato.dificultadPistas());
	}
	
	
}
