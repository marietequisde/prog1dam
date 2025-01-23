package Actividades2;

import entrada.Teclado;

public class Actividad2x12 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 10, 60);

		System.out.println(invertirFrase(frase));
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
	
	public static String invertirFrase(String frase) {
		int ultPalabra = 0;
		String retVal = "";
		frase = frase.trim() + " ";
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				retVal = frase.substring(ultPalabra, i).trim() + " " + retVal;
				ultPalabra = i;
			}
		}
		
		return retVal.trim();
	}

}
