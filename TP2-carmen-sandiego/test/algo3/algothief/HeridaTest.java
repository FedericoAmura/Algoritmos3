package algo3.algothief;


import org.junit.Assert;
import org.junit.Test;

public class HeridaTest {
	
	@Test
	public void heridaPorCuchilloDevuelveCorrectamenteDescripcionYTiempo() {
		
		Herida unaHerida = Herida.heridaPorCuchillo();
		Assert.assertEquals("fuiste herido con un cuchillo.", unaHerida.getDescripcion());
		Assert.assertEquals(2, unaHerida.getHorasPorHerida());
	}
	
	@Test
	public void heridaPorArmaDevuelveCorrectamenteDescripcionYTiempo() {
		
		Herida unaHerida = Herida.heridaPorArma();
		Assert.assertEquals("fuiste herido con un arma de fuego.", unaHerida.getDescripcion());
		Assert.assertEquals(4, unaHerida.getHorasPorHerida());
	}
}
