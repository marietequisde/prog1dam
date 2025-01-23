package Actividades2;

import entrada.Teclado;

public class Actividad2x05 {

	public static void main(String[] args) {
		int opcion;
		
		do {
			opcion = mostrarMenu();
			
			switch (opcion) {
				case 0:
					break;
	
				case 1:
					System.out.println(leerFrase("¿Frase? ", 60).toUpperCase());
					break;
					
				case 2:
					System.out.println(leerFrase("¿Frase? ", 60).toLowerCase());
					break;
					
				default:
					System.err.println("La opción de menú debe estar comprendida entre 0 y 2.");
					break;
			}
			System.out.println();
		} while (opcion != 0);
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
	
	public static int mostrarMenu() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Convertir todos los caracteres de una frase a letras mayúsculas.");
		System.out.println("(2) Convertir todos los caracteres de una frase a letras minúsculas.");
		
		return Teclado.leerEntero("¿Opción? ");
	}

}
