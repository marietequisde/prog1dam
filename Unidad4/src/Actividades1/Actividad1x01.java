package Actividades1;

import entrada.Teclado;

public class Actividad1x01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = Teclado.leerCaracter("Introduce un carácter: ");
		System.out.printf("El carácter %c %ses un número arábigo.",
							c, esNumeroArabigo(c) ? "" : "no ");
	}
	
	public static boolean esNumeroArabigo(char c) {
		return c >= '\u0030' && c <= '\u0039';
	}

}
