package cosasDePersistencia;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class cosasDePersistenciaTest {
	
	private String nombreArchivo;
	private ContenedorDeLadrones ladrones;
	
	@Before
	public void before() {
		
		this.nombreArchivo = "ladrones.xml";
		
		this.ladrones = new ContenedorDeLadrones();
		
		PlantillaLadron ladron1 = new PlantillaLadron("jose", "Masculino", "Futbol", "Negro", "Anillo", "Automovil");
		PlantillaLadron ladron2 = new PlantillaLadron("Maria", "Femenino", "Basquet", "Rubio", "Cartera roja", "Motocicleta");
		
		ladrones.agregarLadron(ladron1);
		ladrones.agregarLadron(ladron2);
	}
	
	/* Borra el archivo despues de la prueba. */
	@After
	public void after() {
		
		File archivo = new File(this.nombreArchivo);
		
		if (archivo.exists()) {
			
			archivo.delete();
		}
	}
	
	@Test
	public void guardarYRecuperarLadron() throws ParserConfigurationException, TransformerException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element ladron = ladrones.serializar(doc);
		Assert.assertNotNull(ladron);
		
		// Hasta aqui hemos serializado el ladron con todo su contenido.
		// Ahora tenemos que bajarlo a disco.
		
		doc.appendChild(ladron);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		DOMSource source = new DOMSource(doc);
		
		File archivoDestino = new File(this.nombreArchivo);
		StreamResult result = new StreamResult(archivoDestino);
		
		transformer.transform(source, result);
		
		File archivo = new File(this.nombreArchivo);
		Assert.assertTrue(archivo.exists());	
		
		// Ahora hacemos lo inveso, levantamos el archivo de disco 
		// y verificamos que los objetos se hidratan correctamente

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		/* Document doc = dBuilder.newDocument(); */
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		ContenedorDeLadrones ladronesCargados = ContenedorDeLadrones.hidratar(doc);
		
		Assert.assertNotNull(ladronesCargados);
		Assert.assertEquals(2, ladronesCargados.getCantidadDeLadrones());
		
		PlantillaLadron miLadron = ladronesCargados.getLadron(1); //Esto no se debe hacer, viola el encapsulamiento.
	
		Assert.assertEquals(miLadron.getNombre(), "Maria");
	}
}