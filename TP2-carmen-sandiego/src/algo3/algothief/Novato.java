package algo3.algothief;

public class Novato extends GradoPolicial {

	public Novato() {
		super(900, "Novato");
	}
	
	@Override
	public boolean ascensoDisponible(int cantidadDeArrestos) {
		if(cantidadDeArrestos>=5){
			return true;
		}
		return false;
	}

	@Override
	public GradoPolicial ascender() {
		return (new Detective());
		
	}

	@Override
	public String dificultadObjeto() {
		return "Comun";
	}

	@Override
	public String dificultadPistas() {
		return "Facil";
	}
}
