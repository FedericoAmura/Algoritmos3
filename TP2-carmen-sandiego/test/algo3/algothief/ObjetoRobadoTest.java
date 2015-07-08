package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjetoRobadoTest {
	
	private Ciudad miCiudad;
	private ObjetoRobado unObjeto;
	
	@Before
	public void setUp() {
		
		miCiudad = new Ciudad("Buenos Aires", "descripcion");
		unObjeto = new ObjetoRobado("La espada de San Martin", 4 , miCiudad);
	}

	@Test
	public void seCreaCorrectamenteElObjetoRobadoBasico() {
		
		Assert.assertEquals(4, unObjeto.getValor());
		Assert.assertEquals("La espada de San Martin", unObjeto.getNombre());
		Assert.assertEquals(miCiudad, unObjeto.getCiudad());
	}
}
