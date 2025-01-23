package Actividades2;

import entrada.Teclado;

public class Actividad2x06 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 10, 40);
		for(int i = 0; i < frase.length(); i++) {
			System.out.println(frase.substring(0, i+1));
		}
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

}
