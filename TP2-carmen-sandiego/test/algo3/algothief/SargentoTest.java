package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SargentoTest {

	private Sargento unSargento;

	@Before
	public void setUp(){
		
		this.unSargento = new Sargento();
	}

	@Test
	public void SargentoVelocidadTest(){
		
		Assert.assertEquals(2, unSargento.costoDeViajeEnHoras(2500));
	}
	
	@Test
	public void SargentoNoDeberiaPoderAscender(){
		
		Assert.assertEquals(false, unSargento.ascensoDisponible(25));
	}
	
	@Test
	public void SargentoAlAscenderDeberiaDevolverNull(){
		
		Assert.assertEquals(null, unSargento.ascender());
	}
	
	
	@Test
	public void SargentoDeberiaDevolverNombreCorrespondiente(){
		
		Assert.assertEquals("Sargento", unSargento.getNombre());
	}
	
	@Test
	public void dificultadObjetoDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("MuyValioso", unSargento.dificultadObjeto());
	}
	
	@Test
	public void dificultadPistaDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Dificil", unSargento.dificultadPistas());
	}
	
	
}
