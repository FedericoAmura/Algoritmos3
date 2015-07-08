package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PoliciaTest {
	
	private Policia unPolicia;
	
	@Before
	public void setUp() {
		
		unPolicia = new Policia("Juan");
	}

	@Test
	public void nuevoPoliciaTieneUnNombre() {
		
		Assert.assertEquals("Juan",unPolicia.getNombre());
	}

	@Test
	public void nuevoPoliciaTieneGradoNovato() {
		
		Assert.assertEquals("Novato", (unPolicia.getGrado()));
	}

	@Test
	public void nuevoPoliciaNoTieneNingunArresto() {
	
		Assert.assertEquals(0, unPolicia.getCantidadArrestos());
	}

	@Test
	public void aumentarArrestosAumentaLaCantidadDeArrestosEn1() {
		
		unPolicia.aumentarArrestos();
		Assert.assertEquals(1, unPolicia.getCantidadArrestos());
	}
	
	@Test
	public void aumentarArrestosEn5CambiaElGradoADetective(){
		
		for(int i =0; i<=5; i++){
			unPolicia.aumentarArrestos();
		}
		Assert.assertEquals("Detective", unPolicia.getGrado());
	}
	
	@Test
	public void emitirOrdenDeArrestoConAlMenos3CaracteristicasBienDevuelveTrue() {
		
		Juego unJuego = new Juego();
		Ladron unLadron = new Ladron("elLadron", "Masculino", "Negro", "Cicatriz", "Moto", "Natacion");
		unJuego.setLadron(unLadron);
		unJuego.setPolicia(unPolicia);
		Assert.assertEquals(true, unPolicia.emitirOrdenDeArresto("Masculino", "Negro", "Cicatriz", "Moto", "Natacion"));
	}
	
	@Test
	public void emitirOrdenDeArrestoConAlMenos1CaracteristicaIncorrectaDevuelveFalse() {
		
		Juego unJuego = new Juego();
		Ladron unLadron = new Ladron("elLadron", "Masculino", "Negro", "Cicatriz", "Moto", "Natacion");
		unJuego.setLadron(unLadron);
		unJuego.setPolicia(unPolicia);
		Assert.assertEquals(false, unPolicia.emitirOrdenDeArresto("Femenino", "Negro", "Cicatriz", "Moto", "Natacion"));
	}
	
	@Test
	public void getDificultadObjetoDevuelveCorrectamenteUnString() {
		
		Assert.assertEquals("Comun", unPolicia.getDificultadObjeto());
	}
	
	@Test
	public void getDificultadPistaDevuelveCorrectamenteUnString() {
		
		Assert.assertEquals("Facil", unPolicia.getDificultadPista());
	}
}
