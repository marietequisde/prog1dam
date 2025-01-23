package Actividades1;

import entrada.Teclado;

public class Actividad1x04 {

	public static void main(String[] args) {
		char c = Teclado.leerCaracter("Introduce un carácter: ");
		
		if (!esLetra(c)) {
			System.err.println("El carácter debe ser una letra.");
		} else {
			System.out.printf("El carácter %c convertido a letra mayúscula es %c.\n",
								c, convertirALetraMayuscula(c));
			System.out.printf("El carácter %c convertido a letra minúscula es %c.\n",
					c, convertirALetraMinuscula(c));
		}
	}
	
	public static char convertirALetraMayuscula(char c) {
		if (esLetraMinuscula(c)) {
			return String.valueOf(c).toUpperCase().charAt(0);
		}
		return c;
	}
	
	public static char convertirALetraMinuscula(char c) {
		if (esLetraMayuscula(c)) {
			return String.valueOf(c).toLowerCase().charAt(0);
		}
		return c;
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
