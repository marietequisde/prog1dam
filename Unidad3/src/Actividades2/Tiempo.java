package Actividades2;

public class Tiempo {
	
	int hora;
	int minuto;
	int segundo;
	
	public Tiempo(int hora, int minuto, int segundo) {
		super();
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}
	
	public String obtenerEstado() {
		return String.format("%02d:%02d:%02d", hora, minuto, segundo);
	}
	
	public boolean sumar(Tiempo otroTiempo) {
		Tiempo tiempoAux = new Tiempo(hora, minuto, segundo);
		tiempoAux.hora += otroTiempo.hora;
		tiempoAux.minuto += otroTiempo.minuto;
		tiempoAux.segundo += otroTiempo.segundo;
		
		if (tiempoAux.segundo > 59) {
			tiempoAux.segundo -= 60;
			tiempoAux.minuto += 1;
		}
		if (tiempoAux.minuto > 59) {
			tiempoAux.minuto -= 60;
			tiempoAux.hora += 1;
		}
		
		if (validar(tiempoAux.hora, tiempoAux.minuto, tiempoAux.segundo)) {
			this.hora = tiempoAux.hora;
			this.minuto = tiempoAux.minuto;
			this.segundo = tiempoAux.segundo;
			return true;
		}
		
		return false;
		
	}
	
	public boolean restar(Tiempo otroTiempo) {
		Tiempo tiempoAux = new Tiempo(hora, minuto, segundo);
		tiempoAux.hora -= otroTiempo.hora;
		tiempoAux.minuto -= otroTiempo.minuto;
		tiempoAux.segundo -= otroTiempo.segundo;
		
		if (tiempoAux.segundo < 0) {
			tiempoAux.segundo += 60;
			tiempoAux.minuto -= 1;
		}
		if (tiempoAux.minuto < 0) {
			tiempoAux.minuto += 60;
			tiempoAux.hora -= 1;
		}
		
		if (validar(tiempoAux.hora, tiempoAux.minuto, tiempoAux.segundo)) {
			this.hora = tiempoAux.hora;
			this.minuto = tiempoAux.minuto;
			this.segundo = tiempoAux.segundo;
			return true;
		}
		
		return false;
		
	}
	
	public static boolean validar(int hora, int minuto, int segundo) {
		return entre(hora, 0, 23) && 
				entre(minuto, 0, 59) && 
				entre(segundo, 0, 59);
	}
	
	private static boolean entre(int comparar, int numA, int numB) {
		return numA <= comparar && comparar <= numB;
	}
}
