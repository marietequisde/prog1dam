package Actividades1;

import entrada.Teclado;

public class Actividad1x03 {

	public static void main(String[] args) {
		char c = Teclado.leerCaracter("¿Carácter? ");
		System.out.printf("El carácter %c %ses un signo de puntuación.", c, 
							esSignoPuntuacion(c) ? "" : "no ");

	}
	
	public static boolean esSignoPuntuacion(char c) {
		String signos = ".,;:-\'\"()[]{}¿?!¡";
		return signos.contains(c+"");
	}

}
