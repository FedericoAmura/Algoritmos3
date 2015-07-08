package algo3.algothief;

public class Ciudad {
	
	private String nombre;
	private String descripcion; 
	private int costoVisitarEdificio;
	private String[] pistas;
	
	private Herida unaHerida = null;
	private static String pistaGenerica = "No hemos visto a nadie con esas caracteristicas";

	public Ciudad (String nombre, String descripcion) {
				
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoVisitarEdificio = 1;
		this.pistas = new String[3];
		this.cargarPistaBolsaOBanco(pistaGenerica);
		this.cargarPistaBiblioteca(pistaGenerica);
		this.cargarPistaPuertoOAeropuerto(pistaGenerica);
	}
	
	public void setHerida(Herida laHerida) {
		
		this.unaHerida = laHerida;
	}
	
	public Herida getHerida() {
		
		return this.unaHerida;
	}
	
	public void cargarPistaBolsaOBanco(String pista) {
		
		this.pistas[0] = pista;
	}
	
	
	public void cargarPistaBiblioteca(String pista) {
		
		
		this.pistas[1] = pista;
	}
	
	public void cargarPistaPuertoOAeropuerto(String pista) {
		
		this.pistas[2] = pista;
	}
	
	public String getBolsaOBanco() {
		
		this.agregarHoras();
		return this.pistas[0];
	}
	
	public String getBiblioteca() {
		
		this.agregarHoras();
		return this.pistas[1];
	}
	
	public String getPuertoOAeropuerto() {
		
		this.agregarHoras();
		return this.pistas[2];
	}
	
	private void agregarHoras() {

		TiempoDeJuego.getInstancia().sumarHoras(costoVisitarEdificio);
		
		if ( costoVisitarEdificio < 3 ) costoVisitarEdificio++;
	}
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	public String getDescripcionGeografica() {
		
		return descripcion;
	}

	public void aumentarHorasPorHerida() {
		if(unaHerida != null) {
			
			TiempoDeJuego.getInstancia().sumarHoras(unaHerida.getHorasPorHerida());
		}
	}

	public void reestablecerPistas() {
		this.cargarPistaBolsaOBanco(pistaGenerica);
		this.cargarPistaBiblioteca(pistaGenerica);
		this.cargarPistaPuertoOAeropuerto(pistaGenerica);
	}

	public void reestablecerHeridas() {
		
		this.unaHerida = null;
	}
}
