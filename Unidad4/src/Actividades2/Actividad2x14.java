package Actividades2;

import entrada.Teclado;

public class Actividad2x14 {

	public static void main(String[] args) {
		String frase = leerFraseEnMayusculas("¿Frase? ");
		String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int letrasDistintas = 0;
		for (int i = 0; i < abecedario.length(); i++) {
			char letra = abecedario.charAt(i);
			int apariciones = contarApariciones(String.valueOf(letra) + String.valueOf(letra), frase);
			if (apariciones > 0) {
				letrasDistintas++;
				System.out.printf("La letra %c aparece %d veces.\n", letra, apariciones);
			}
		}
		System.out.printf("La frase tiene %d letras distintas.", letrasDistintas);

	}

	public static int contarApariciones(String letra, String frase) {
		return 0; // TODO
	}

	public static String leerFraseEnMayusculas(String mensaje) {
		String frase = null;

		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (tieneMinusculas(fraseAux)) {
				mostrarError();
			} else {
				frase = fraseAux;
			}
		} while (frase == null);

		return frase;
	}

	public static boolean tieneMinusculas(String frase) {
		return frase.chars().filter(c -> Character.isLowerCase(c)).findFirst().isPresent();
	}

	public static void mostrarError() {
		System.out.println("La frase no debe contener ninguna letra minúscula.");
	}

}
