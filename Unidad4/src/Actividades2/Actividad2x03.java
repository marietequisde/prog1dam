package Actividades2;

import java.util.Objects;
import java.util.stream.Collectors;

import entrada.Teclado;

public class Actividad2x03 {

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 60);
		String vocales = obtenerVocales(frase);
		String consonantes = obtenerConsonantes(frase);
		
		System.out.printf("La frase tiene %d letras vocales.\n", 
							vocales.length());
		System.out.printf("Letras Vocales: %s\n", vocales);
		System.out.printf("La frase tiene %d letras consonantes.\n", 
							consonantes.length());
		System.out.printf("Letras Consonantes: %s\n", consonantes);
		
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
	
	public static String obtenerVocales(String frase) {
		return frase.chars().mapToObj(c -> (char) c)
			.filter(c -> esVocal(c))
			.map(Objects::toString)
	        .collect(Collectors.joining(""));
	}
	
	public static String obtenerConsonantes(String frase) {
		return frase.chars().mapToObj(c -> (char) c)
			.filter(c -> esConsonante(c))
			.map(Objects::toString)
	        .collect(Collectors.joining(""));
	}
	
	public static boolean esConsonante(char c) {
		return esLetra(c) && !esVocal(c) && !"áéíóúÁÉÍÓÚ".contains(c+"");
	}
	
	public static boolean esVocal(char c) {
		return "AEIOUaeiou".contains(c+"");
	}
	
	public static boolean esLetra(char c) {
		return esLetraMinuscula(c) || esLetraMayuscula(c);
	}
	
	public static boolean esLetraMayuscula(char c) {
		String otrosCaracteres = "ÁÉÍÓÚ";
		return (c >= 'A' && c <= 'Z') || otrosCaracteres.contains(c+"");
	}
	
	public static boolean esLetraMinuscula(char c) {
		String otrosCaracteres = "áéíóú";
		return (c >= 'a' && c <= 'z') || otrosCaracteres.contains(c+"");
	}
}
