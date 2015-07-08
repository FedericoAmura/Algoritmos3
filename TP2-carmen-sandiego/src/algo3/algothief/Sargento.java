package algo3.algothief;

public class Sargento extends GradoPolicial {
	
	public Sargento(){
		super(1500, "Sargento");
	}

	@Override
	public boolean ascensoDisponible(int cantidadDeArrestos) {
		return false;
	}

	@Override
	public GradoPolicial ascender() {
		return null;
	}

	@Override
	public String dificultadObjeto() {
		return "MuyValioso";
	}

	@Override
	public String dificultadPistas() {
		return "Dificil";
	}
}
