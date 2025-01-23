package Actividades1;

import entrada.Teclado;

public class Actividad1x02 {

	public static void main(String[] args) {
		char c = Teclado.leerCaracter("Introduce un carácter: ");
		System.out.printf("El carácter %c %s.", c, 
							esLetraMayuscula(c) ? "es una letra mayúscula" :
							esLetraMinuscula(c) ? "es una letra minúscula" : 
							"no es una letra");

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
