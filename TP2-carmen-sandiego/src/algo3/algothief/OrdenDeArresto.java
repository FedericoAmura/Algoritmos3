package algo3.algothief;

public class OrdenDeArresto extends CaracteristicasLadron {
	
	public OrdenDeArresto(String sexo, String cabello, String senia, String vehiculo, String hobby) {
		
		this.cabello = cabello;
		this.sexo = sexo;
		this.vehiculo = vehiculo;
		this.hobby = hobby;
		this.senia = senia;
				
		TiempoDeJuego.getInstancia().sumarHoras(3);
	}
	
	public boolean compararCon(Ladron unLadron) {
		
		int aciertos = 0;
		int genericos = 0;
		String generico = "------";
		//veo a cuantas cosas le acerte
		if (this.cabello.equals(unLadron.getCabello())) aciertos++;	
		if (this.hobby.equals(unLadron.getHobby())) aciertos++;
		if (this.senia.equals(unLadron.getSenia())) aciertos++;
		if (this.sexo.equals(unLadron.getSexo())) aciertos++;
		if (this.vehiculo.equals(unLadron.getVehiculo())) aciertos++;
		//veo cuantos genericos hubo
		if (this.getCabello().equals(generico)) genericos++;
		if (this.getHobbie().equals(generico)) genericos++;
		if (this.getSenia().equals(generico)) genericos++;
		if (this.getSexo().equals(generico)) genericos++;
		if (this.getVehiculo().equals(generico)) genericos++;
		//chequeo que le haya acertado o haya un generico
		if ((aciertos >= 3) && (aciertos+genericos == 5)) return true;
		return false;
	}
	
	public String getCabello(){
		return cabello;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public String getVehiculo(){
		return vehiculo;
	}
	
	public String getHobbie(){
		return hobby;
	}
	
	public String getSenia(){
		return senia;
	}

}
