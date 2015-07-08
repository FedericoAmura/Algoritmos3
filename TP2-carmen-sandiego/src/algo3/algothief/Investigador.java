package algo3.algothief;

public class Investigador extends GradoPolicial {
	
	public Investigador(){
		super(1300, "Investigador");
	}

	@Override
	public boolean ascensoDisponible(int cantidadDeArrestos) {
		if(cantidadDeArrestos>=20) return true;
		return false;
	}

	@Override
	public GradoPolicial ascender() {
		return(new Sargento());
	}

	@Override
	public String dificultadObjeto() {
		return "Valioso";
	}

	@Override
	public String dificultadPistas() {
		return "Medio";
	}
}
