package algo3.algothief;

public abstract class GradoPolicial {
	
	protected int velocidad;
	protected String nombreRango;
	
	public GradoPolicial(int velocidad, String nombre) {
		
		this.velocidad = velocidad;
		this.nombreRango = nombre;
	}
	
	public abstract boolean ascensoDisponible(int cantidadDeArrestos);
	
	public abstract GradoPolicial ascender();
	
	public int costoDeViajeEnHoras(int distancia){
		
		return((int)Math.round((double)distancia/(double)velocidad));
	}
	
	public String getNombre(){
		
		return(nombreRango);
	}
	public abstract String dificultadObjeto();
	
	public abstract String dificultadPistas();
}

	
