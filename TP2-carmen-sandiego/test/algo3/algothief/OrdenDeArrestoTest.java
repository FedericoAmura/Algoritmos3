package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrdenDeArrestoTest {
	private OrdenDeArresto orden;
	
	@Before
	public void setup(){
		orden = new OrdenDeArresto("masculino","morocho","anillo","auto","futbol");
	}
	
	@Test
	public void seCreoLaOrdenDeArrestoCorrectamente(){
		Assert.assertEquals("morocho",orden.getCabello());
		Assert.assertEquals("masculino",orden.getSexo());
		Assert.assertEquals("auto",orden.getVehiculo());
		Assert.assertEquals("futbol",orden.getHobbie());
		Assert.assertEquals("anillo",orden.getSenia());
	}
	
	@Test
	public void seAdelantaElRelojCuandoCreoLaOrden(){
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		
		Assert.assertEquals(0, instancia1.getHoras());
		orden = new OrdenDeArresto("morocho","masculino","auto","futbol","anillo");
		Assert.assertEquals(3, instancia1.getHoras());
	}

}
