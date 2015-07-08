package algo3.algothief;


/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetectiveTest {

	private Detective unDetective;

	@Before
	public void setUp(){
		
		this.unDetective = new Detective();
	}

	@Test
	public void DetectiveVelocidadTest(){
		
		Assert.assertEquals(2, unDetective.costoDeViajeEnHoras(2500));
	}
	
	@Test
	public void DetectiveNoDeberiaPoderAscenderConMenosDe10Arrestos(){
		
		Assert.assertEquals(false, unDetective.ascensoDisponible(8));
	}
	
	@Test
	public void DetectiveDeberiaPoderAscenderCon10Arrestos(){
		
		Assert.assertEquals(true, unDetective.ascensoDisponible(10));
	}
	
	@Test
	public void DetectiveAlAscenderDeberiaDevolverUnInvestigador(){
		
		Assert.assertEquals(Investigador.class, unDetective.ascender().getClass());
	}
	
	
	@Test
	public void DetectiveDeberiaDevolverNombreCorrespondiente(){
		
		Assert.assertEquals("Detective", unDetective.getNombre());
	}
	
	@Test
	public void dificultadObjetoDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Valioso", unDetective.dificultadObjeto());
	}
	
	@Test
	public void dificultadPistaDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Facil", unDetective.dificultadPistas());
	}
	
}
