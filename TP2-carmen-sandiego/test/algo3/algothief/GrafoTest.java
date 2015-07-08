package algo3.algothief;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	private Grafo<String, Integer> grafo;
	
	@Before
	public void setUp(){
		grafo = new Grafo<String, Integer>();
	}

	@Test
	public void CrearGrafoEstaVaciotest() {
		Assert.assertEquals(0, grafo.size());
	}
	
	@Test
	public void AgregarVerticeAGrafoDevuelveTrue(){
		Assert.assertEquals(true, grafo.agregarVertice("vertice"));
	}
	
	@Test
	public void AgregarMismoVerticeAGrafoDevuelveFalse(){
		grafo.agregarVertice("vertice");
		Assert.assertEquals(false, grafo.agregarVertice("vertice"));
	}
	
	@Test
	public void AgregarVerticeAumentaSizeEn1(){
		grafo.agregarVertice("vertice");
		Assert.assertEquals(1, grafo.size());
	}
	
	@Test
	public void BorrarVerticeExistenteReduceSizeEn1(){
		grafo.agregarVertice("vertice");
		grafo.borrarVertice("vertice");
		Assert.assertEquals(0, grafo.size());
	}
	
	@Test
	public void AgregarAristaEntreVerticesExistentesDevuelveTrue(){
		grafo.agregarVertice("vertice");
		grafo.agregarVertice("otroVertice");
		Assert.assertEquals(true, grafo.agregarArista("vertice", "otroVertice", 100));
	}
	
	@Test
	public void AgregarAristaEntreVerticesInexistentesDevuelveFalse(){
		Assert.assertEquals(false, grafo.agregarArista("vertice", "otroVertice", 100));
	}
	
	@Test
	public void ObtenerPesoDevuelvePesoCorrespondiente(){
		grafo.agregarVertice("vertice");
		grafo.agregarVertice("otroVertice");
		grafo.agregarArista("vertice", "otroVertice", 100);
		Assert.assertEquals(100, grafo.obtenerPeso("vertice", "otroVertice").intValue());
	}

}
