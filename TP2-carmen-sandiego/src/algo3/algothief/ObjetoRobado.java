package algo3.algothief;

public class ObjetoRobado {
	
	private String nombre;
	private int valor;
	private Ciudad ciudadDelRobo;
	
	public ObjetoRobado(String nombre, int valor, Ciudad ciudad){
		
		this.nombre = nombre;
		this.valor = valor;
		this.ciudadDelRobo = ciudad;
	}

	public String getNombre() {
		
		return nombre;
	}
	
	public int getValor() {
		
		return valor;
	}
	
	public Ciudad getCiudad() {
		
		return this.ciudadDelRobo;
	}
}
