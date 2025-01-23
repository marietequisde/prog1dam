package ahorcado;
import util.Constantes;
import util.Constantes.ESTADO;
import util.Mensajes;
import util.Utils;

public class JuegoAhorcado {
	
	private String palabra;
	private int intentosRestantes;
	private String letrasAcertadas;
	private ESTADO estado;
	
	public JuegoAhorcado() {
		this.palabra = Utils.obtenerPosicionAleatoria(Constantes.PALABRAS);
		this.intentosRestantes = Constantes.MAX_INTENTOS;
		this.letrasAcertadas = "";
		this.estado = ESTADO.JUGANDO;
	}
	
	public JuegoAhorcado(String[] palabras, int maxIntentos) {
		this.palabra = Utils.obtenerPosicionAleatoria(palabras);
		this.intentosRestantes = maxIntentos;
		this.letrasAcertadas = "";
		this.estado = ESTADO.JUGANDO;
	}
	
	public String obtenerTablero() {
		String tablero = "";
		
		for (int i = 0; i < palabra.length(); i++) {
			char caracter = palabra.charAt(i);
			if (Utils.contieneCaracterIgnoreCase(letrasAcertadas, caracter)) {
				tablero += String.valueOf(caracter);
			} else {
				tablero += Constantes.CARACTER_OCULTO + " ";
			}
		}
		
		return Mensajes.INTENTOS_RESTANTES + intentosRestantes + "\n" + tablero + "\n";
	}
	
	public String jugarTurno(char letra) {
		switch (estado) {
		case JUGANDO:
			return realizarJugada(letra);
			
		case DERROTA:
			return pantallaDerrota();
			
		case VICTORIA:
			return pantallaVictoria();

		default:
			return Mensajes.ESTADO_INCORRECTO;
		}
	}
	
	public ESTADO obtenerEstado() {
		return estado;
	}
	
	private String realizarJugada(char letra) {
		if (!Utils.contieneCaracterIgnoreCase(letrasAcertadas, letra)) {
			if (Utils.contieneCaracterIgnoreCase(palabra, letra)) {
				letrasAcertadas += String.valueOf(letra);
			} else {
				intentosRestantes--;
			}
			if (palabraAcertada()) {
				estado = ESTADO.VICTORIA;
				return pantallaVictoria();
			} else if (intentosRestantes > 1) {
				return obtenerTablero();
			} else {
				estado = ESTADO.DERROTA;
				return pantallaDerrota();
			}
		} else {
			return Mensajes.LETRA_YA_USADA;
		}
	}
	
	private String pantallaVictoria() {
		return Mensajes.VICTORIA + "\n" + "La palabra era: " + palabra;
	}
	
	private String pantallaDerrota() {
		return Mensajes.DERROTA + "\n" + "La palabra era: " + palabra;
	}
	
	private boolean palabraAcertada() {
		boolean acertada = true;
		
		for (int i = 0; i < palabra.length(); i++) {
			if (!Utils.contieneCaracterIgnoreCase(letrasAcertadas, palabra.charAt(i))) {
				acertada = false;
			}
		}
		
		return acertada;
	}
	
	
}
