package Actividades2;

import entrada.Teclado;

public class Actividad2x04 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 60);
		escribirParesImpares(frase);
	}
	
	public static String leerFrase(String mensaje, int longitudMax) {
		String frase = null;
		
		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (fraseAux.length() > longitudMax) {
				System.err.printf("La frase debe tener %d caracteres como máximo.\n", 
									longitudMax);
			} else {
				frase = fraseAux;
			}
		} while (frase == null);
		
		return frase;
	}
	
	public static void escribirParesImpares(String frase) {
		String pares = "";
		String impares = "";
		
		for (int i = 0; i < frase.length(); i+=2) {
			pares += frase.charAt(i);
			impares += frase.charAt(i+1);
		}
		
		System.out.printf("Los caracteres de posiciones pares de la frase son:\n%s\n", pares);
		System.out.printf("Los caracteres de posiciones impares de la frase son:\n%s\n", impares);
	}

}
