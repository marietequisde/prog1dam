package controlador;

import ahorcado.JuegoAhorcado;
import entrada.Teclado;
import util.Constantes.ESTADO;

public class Jugar {

	public static void main(String[] args) {
		JuegoAhorcado ahorcado = new JuegoAhorcado();
		ESTADO estado;
		
		System.out.println(ahorcado.obtenerTablero());
		
		do {
			System.out.println(ahorcado.jugarTurno(Teclado.leerCaracter("Introduce una letra: ")));
			estado = ahorcado.obtenerEstado();
		} while (ESTADO.JUGANDO.equals(estado));

	}

}
