package algo3.algothief;

public class TiempoDeJuego {
	
	private static TiempoDeJuego INSTANCIA = null;
	private static int horasDelDia;
	private static int diaDeLaSemana;
	private static String[] nombreDias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
	private static Juego elJuego;
	
	private  TiempoDeJuego() {
			
		horasDelDia = 0;
		diaDeLaSemana = 1;
	}
				
	public synchronized static TiempoDeJuego getInstancia() {
			
		if(INSTANCIA == null) {
				
			INSTANCIA = new TiempoDeJuego();
		}
			
		return (INSTANCIA);
	}
		
	public int getHoras() {
			
		return horasDelDia;
	}
	
	public int getDia(){
		
		return diaDeLaSemana;
	} 
	
	public String getNombreDia(){
		
		return nombreDias[getDia() % 7];
	}
	
	public void setJuego(Juego unJuego){
		elJuego = unJuego;
	}
	
	public void sumarHoras(int aumento) {
			
		horasDelDia += aumento;
			
		int diasTranscurridos = horasDelDia/24;
			
		for(int i = 0; i < diasTranscurridos ; i++) {

			diaDeLaSemana++;
			horasDelDia = horasDelDia -16; //16 porque duerme, lo lindo seria hacerlo con una exception pero te la regalo
		}
		
		if (this.getHorasRestantes()<0) TiempoDeJuego.elJuego.finalizarCaso(false);

	}

	public void reset() {
			
		horasDelDia = 0;
		diaDeLaSemana = 1;
	}
	
	public int horasJugadas(){
		//TODO acordarme de cambiar esto despues porque es un desastre
		return (161- this.getHorasRestantes());
	}
	
	public int getHorasRestantes() {
		// esto es para llevar una cuenta de cuantas horas le quedan para jugar 
		//contando que del lunes a las 7am  hasta el domingo a las 5pm son 154hs
		return (161 - horasDelDia - (24*(diaDeLaSemana-1)));
	}
}
