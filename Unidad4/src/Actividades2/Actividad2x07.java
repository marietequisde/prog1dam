package Actividades2;

import entrada.Teclado;

public class Actividad2x07 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 10, 40);
		rotacionesDerecha(frase);
		rotacionesIzquierda(frase);
	}
	
	public static String leerFrase(String mensaje, int longitudMin, int longitudMax) {
		String frase = null;
		
		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (fraseAux.length() > longitudMax || fraseAux.length() < longitudMin) {
				System.err.printf("La frase debe tener %d caracteres como mínimo.\n", 
									longitudMin);
				System.err.printf("La frase debe tener %d caracteres como máximo.\n", 
									longitudMax);
			} else {
				frase = fraseAux;
			}
		} while (frase == null);
		
		return frase;
	}
	
	public static void rotacionesIzquierda(String frase) {
		System.out.println("\nRotaciones hacia la izquierda:");
		System.out.println(frase);
		for(int i = 0; i < frase.length()-1; i++) {
			frase = rotarIzquierda(frase);
			System.out.println(frase);
		}
	}
	
	public static String rotarIzquierda(String frase) {
		return (frase + frase.charAt(0)).substring(1);
	}
	
	public static void rotacionesDerecha(String frase) {
		System.out.println("\nRotaciones hacia la derecha:");
		System.out.println(frase);
		for(int i = 0; i < frase.length()-1; i++) {
			frase = rotarDerecha(frase);
			System.out.println(frase);
		}
	}
	
	public static String rotarDerecha(String frase) {
		return (frase.charAt(frase.length()-1) + frase)
					.substring(0, frase.length());
	}
	
	

}
