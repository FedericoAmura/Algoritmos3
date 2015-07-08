package algo3.algothief;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class LadronTest {

	private Ladron unLadron;
	
	@Before
	public void setUp() {
		
		unLadron = new Ladron("Pedro","masculino","morocho","anillo","limusina","paracaidismo");
	}
	
	@Test
	public void elLadronTieneBienSusDatos() {
		
		Assert.assertEquals("Pedro",unLadron.getNombre());
		Assert.assertEquals("morocho",unLadron.getCabello());
		Assert.assertEquals("masculino",unLadron.getSexo());
		Assert.assertEquals("limusina",unLadron.getVehiculo());
		Assert.assertEquals("paracaidismo",unLadron.getHobby());  
		Assert.assertEquals("anillo",unLadron.getSenia());
	}
	
}
