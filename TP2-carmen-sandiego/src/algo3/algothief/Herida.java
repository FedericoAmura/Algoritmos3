package algo3.algothief;

import java.lang.Math;

public class Herida {
	
	private String descripcion; /* Herida de cuchillo o arma. */
	private int horasPorHerida;
	
	private static String heridaCuchillo = "fuiste herido con un cuchillo.";
	private static String heridaArma = "fuiste herido con un arma de fuego.";
	
	private Herida(String descripcion, int horasPorHerida) {
		
		this.descripcion = descripcion;
		this.horasPorHerida = horasPorHerida;
	}
	
	public static Herida getHeridaAleatoria() {
		
		int numeroAleatorioDeHerida = (int) Math.floor(Math.random()*2);
	
		if (numeroAleatorioDeHerida == 1) {
		
			return Herida.heridaPorArma();
		}
		
		return Herida.heridaPorCuchillo();
	}
	
	public static Herida heridaPorCuchillo() {
		
		Herida herida = new Herida(heridaCuchillo, 2);
		
		return herida;
	}
	
	public static Herida heridaPorArma() {
		
		Herida herida = new Herida(heridaArma, 4);
		
		return herida;
	}
	
	public String getDescripcion() {
		
		return this.descripcion;
	}
	
	public int getHorasPorHerida() {
		
		return this.horasPorHerida;
	}
}
