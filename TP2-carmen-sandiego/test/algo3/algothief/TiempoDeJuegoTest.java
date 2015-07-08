package algo3.algothief;

/*import junit.framework.Assert;*/

import org.junit.Assert;
import org.junit.Test;

public class TiempoDeJuegoTest {

	
	@Test
	public void TestSInicializaElRelojALas0000DelLunes(){
		
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		instancia1.reset();
		
		Assert.assertEquals(0, instancia1.getHoras());
		Assert.assertEquals(1, instancia1.getDia());
	}
	
	@Test
	public void TestSeGeneraUnaSolaInstaciaDeLaClaseTiempoDeJuego() {
		
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		TiempoDeJuego instancia2 = TiempoDeJuego.getInstancia();
			
		Assert.assertEquals(instancia1, instancia2);
	}
	
	@Test
	public void TestSAumentaCantidadDeHorasDesdeTodasLasDirecciones() {
		
		TiempoDeJuego.getInstancia().reset();
		
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		TiempoDeJuego instancia2 = TiempoDeJuego.getInstancia();
		
		Assert.assertEquals(0, instancia1.getHoras());
		
		instancia1.sumarHoras(3);
		
		Assert.assertEquals(3, instancia1.getHoras());
		Assert.assertEquals(3, instancia2.getHoras());
	}
	
	@Test
	public void TestSAumentaCantidadDeHorasSinCrearVariable(){
		
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		
		Assert.assertEquals(0, instancia1.getHoras());
		
		TiempoDeJuego.getInstancia().sumarHoras(4);
		
		Assert.assertEquals(4, instancia1.getHoras());
	}
	
	@Test
	public void TestSCambiaElDiaALas24() {
		
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		
		instancia1.sumarHoras(12);
		
		Assert.assertEquals(1, instancia1.getDia());
		Assert.assertEquals("Lunes", instancia1.getNombreDia());
		
		instancia1.sumarHoras(12);
			
		Assert.assertEquals(2, instancia1.getDia());
		Assert.assertEquals("Martes", instancia1.getNombreDia());
		Assert.assertEquals(8, instancia1.getHoras());
	}
	
	@Test
	public void TestSRecorroLaSemanaViendoHorasPasadasYRestantes() {
		
		TiempoDeJuego.getInstancia().reset();
		TiempoDeJuego instancia1 = TiempoDeJuego.getInstancia();
		
		Assert.assertEquals(1, instancia1.getDia()); //Lunes
		Assert.assertEquals("Lunes", instancia1.getNombreDia());
		Assert.assertEquals(0, instancia1.getHoras()); //00:00hs
		Assert.assertEquals(161, instancia1.getHorasRestantes()); //Quedan 161 horas
		instancia1.sumarHoras(6);
		Assert.assertEquals(1, instancia1.getDia()); //Lunes
		Assert.assertEquals("Lunes", instancia1.getNombreDia());
		Assert.assertEquals(6, instancia1.getHoras()); //06:00hs
		Assert.assertEquals(155, instancia1.getHorasRestantes()); //Quedan 155 horas
		instancia1.sumarHoras(30);
		Assert.assertEquals(2, instancia1.getDia()); //Martes
		Assert.assertEquals("Martes", instancia1.getNombreDia());
		Assert.assertEquals(20, instancia1.getHoras()); //20:00hs
		Assert.assertEquals(117, instancia1.getHorasRestantes()); //Quedan 117 horas
		instancia1.sumarHoras(4);
		Assert.assertEquals(3, instancia1.getDia()); //Miercoles
		Assert.assertEquals("Miercoles", instancia1.getNombreDia());
		Assert.assertEquals(8, instancia1.getHoras()); //8:00hs
		Assert.assertEquals(105, instancia1.getHorasRestantes()); //Quedan 105 horas
		instancia1.sumarHoras(47);
		Assert.assertEquals(5, instancia1.getDia()); //Viernes
		Assert.assertEquals("Viernes", instancia1.getNombreDia());
		Assert.assertEquals(23, instancia1.getHoras()); //23:00hs
		Assert.assertEquals(42, instancia1.getHorasRestantes()); //Quedan 42 horas
		instancia1.sumarHoras(25);
		Assert.assertEquals(7, instancia1.getDia()); //Domingo
		Assert.assertEquals("Domingo", instancia1.getNombreDia());
		Assert.assertEquals(16, instancia1.getHoras()); //16:00hs
		Assert.assertEquals(1, instancia1.getHorasRestantes()); //Queda 1 hora
	}
}
