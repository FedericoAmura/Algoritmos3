package algo3.algothief;

public class Detective extends GradoPolicial{

	public Detective() {
		super(1100, "Detective");
	}

	@Override
	public boolean ascensoDisponible(int cantidadDeArrestos) {
		if(cantidadDeArrestos>=10) return true;
		return false;
	}

	@Override
	public GradoPolicial ascender() {
		return(new Investigador());
	}

	@Override
	public String dificultadObjeto() {
		return "Valioso";
	}

	@Override
	public String dificultadPistas() {
		return "Facil";
	}
}
