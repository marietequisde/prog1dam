package Actividades2;

import entrada.Teclado;

public class Actividad2x10 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 10, 60);
		System.out.printf("La frase tiene %d palabras.\n", contarEspacios(frase) + 1);
	}
	
	public static String leerFrase(String mensaje, int longitudMin, int longitudMax) {
		String frase = null;
		
		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (fraseAux.length() > longitudMax || fraseAux.length() < longitudMin) {
				System.out.printf("La frase debe tener %d caracteres como mínimo.\nLa frase debe tener %d caracteres como máximo.\n", 
		                  longitudMin, longitudMax);
			} else {
				frase = fraseAux;
			}
		} while (frase == null);
		
		return frase;
	}
	
	public static int contarEspacios(String frase) {
		return (int) frase.trim().chars()
							.filter(c -> Character.isWhitespace(c))
							.count();
	}
	
}
