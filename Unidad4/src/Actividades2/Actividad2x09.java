package Actividades2;

import entrada.Teclado;

public class Actividad2x09 {

	public static void main(String[] args) {
		String nombre1 = 
				leerNombreCompletoConTresPalabras("¿Nombre Completo? ");

		System.out.println(formatearNombre(nombre1));
		System.out.println(inicialesNombre(nombre1));


	}
	
	public static String formatearNombre(String nombre) {
		int ap1 = nombre.indexOf(' ')+1;
		int fin = nombre.length();
		
		return nombre.substring(ap1, fin) + ", " + 
				nombre.substring(0, ap1-1);
	}
	
	public static String inicialesNombre(String nombre) {
		int ap1 = nombre.indexOf(' ') + 1;
		int ap2 = nombre.lastIndexOf(' ') + 1;
		
		return String.valueOf(nombre.charAt(ap1)) + 
				String.valueOf(nombre.charAt(ap2)) + 
				String.valueOf(nombre.charAt(0));
	}
	
	public static String leerNombreCompletoConTresPalabras(String mensaje) {
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
		return numEspacios == 2 && 
				!nombre.contains("  ") &&
				!nombre.startsWith(" ") && 
				!nombre.endsWith(" ");
	}
	
	public static void mostrarError() {
		System.err.println("El nombre completo debe tener 2 espacio en blanco.\n"
							+ "El nombre completo no debe contener 2 espacios en blanco seguidos.\n"
							+ "El nombre completo no debe comenzar con un espacio en blanco.\n"
							+ "El nombre completo no debe terminar con un espacio en blanco.");
	}

}
