package FernandezPerezMario_ev1;

import entrada.Teclado;

public class Ejercicio3 {
	
	private final static String TABLA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		String frase = Teclado.leerCadena("Frase: ");
		String fraseCifrada = cifrar(frase);
		String fraseDescifrada = descifrar(fraseCifrada);
		System.out.printf("Frase Cifrada: %s\n", fraseCifrada);
		System.out.printf("Frase Descifrada: %s\n", fraseDescifrada);

	}
	
	public static String cifrar(String texto) {
		String textoCifrado = "";
		
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			textoCifrado += cifrarCaracter(caracter);
		}
		
		return textoCifrado;
	}
	
	public static char cifrarCaracter(char caracter) {
		if (TABLA.contains(String.valueOf(caracter))) {
			caracter = (char) (caracter + 3);
			if (!TABLA.contains(String.valueOf(caracter))) {
				caracter -= TABLA.length();
			}
		}
		return caracter;
	}
	
	public static String descifrar(String texto) {
		String textoCifrado = "";
		
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			textoCifrado += descifrarCaracter(caracter);
		}
		
		return textoCifrado;
	}
	
	public static char descifrarCaracter(char caracter) {
		if (TABLA.contains(String.valueOf(caracter))) {
			caracter = (char) (caracter - 3);
			if (!TABLA.contains(String.valueOf(caracter))) {
				caracter += TABLA.length();
			}
		}
		return caracter;
	}

}
