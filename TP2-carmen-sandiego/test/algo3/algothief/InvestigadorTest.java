package algo3.algothief;


/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvestigadorTest {

	private Investigador unInvestigador;

	@Before
	public void setUp(){
		
		this.unInvestigador = new Investigador();
	}

	@Test
	public void InvestigadorVelocidadTest(){
		
		Assert.assertEquals(2, unInvestigador.costoDeViajeEnHoras(2500));
	}
	
	@Test
	public void InvestigadorNoDeberiaPoderAscenderConMenosDe20Arrestos(){
		
		Assert.assertEquals(false, unInvestigador.ascensoDisponible(15));
	}
	
	@Test
	public void InvestigadorDeberiaPoderAscenderCon20Arrestos(){
		
		Assert.assertEquals(true, unInvestigador.ascensoDisponible(20));
	}
	
	@Test
	public void InvestigadorAlAscenderDeberiaDevolverUnSargento(){
		
		Assert.assertEquals(Sargento.class, unInvestigador.ascender().getClass());
	}
	
	
	@Test
	public void InvestigadorDeberiaDevolverNombreCorrespondiente(){
		
		Assert.assertEquals("Investigador", unInvestigador.getNombre());
	}
	
	@Test
	public void dificultadObjetoDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Valioso", unInvestigador.dificultadObjeto());
	}
	
	@Test
	public void dificultadPistaDevuelveStringCorrespondiente() {
		
		Assert.assertEquals("Medio", unInvestigador.dificultadPistas());
	}
	
}
