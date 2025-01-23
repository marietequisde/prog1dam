package Actividades2;

import entrada.Teclado;

public class Actividad2x08 {

	public static void main(String[] args) {
		String nombre1 = 
				leerNombreCompletoConDosPalabras("¿Nombre Completo 1? ");
		String nombre2 = 
				leerNombreCompletoConDosPalabras("¿Nombre Completo 2? ");
		System.out.println(nombre1);
		System.out.println(nombre2);

	}
	
	public static String leerNombreCompletoConDosPalabras(String mensaje) {
		String frase = null;
		
		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (!esValido(fraseAux)) {
				mostrarError();
			} else {
				frase = fraseAux;
			}
		} while (frase == null);
		
		return frase;
	}
	
	public static boolean esValido(String nombre) {
		long numEspacios = nombre.chars()
								 .filter(c -> Character.isWhitespace(c))
								 .count();
		return numEspacios == 1 && 
				!nombre.startsWith(" ") && 
				!nombre.endsWith(" ");
	}
	
	public static void mostrarError() {
		System.err.println("El nombre completo debe tener 1 espacio en blanco.\n"
							+ "El nombre completo no debe comenzar con un espacio en blanco.\n"
							+ "El nombre completo no debe terminar con un espacio en blanco.");
	}

}
