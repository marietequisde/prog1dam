package Actividades3;

import entrada.Teclado;

public class Actividad3x03 {

	public static final int NUM_CODIGOS= 10;
	
	public static void main(String[] args) {
		String codigo;
		int validos = 0;
		
		for (int i = 1; i <= NUM_CODIGOS; i++) {
			codigo = Teclado.leerCadena("¿Código de Caracteres " + i + "? ");
			if (tieneFormatoValido(codigo)) {
				if (tieneContenidoValido(codigo)) {
					System.out.println("El Código de Carácteres es válido.");
					validos++;
				} else {
					System.out.println("El contenido del Código de Caracteres no es válido.");
				}
			} else {
				System.out.println("El formato del Código de Caracteres no es válido.");
			}
		}

		System.out.printf("\nCódigos Válidos: %d\n", validos);
		System.out.printf("Códigos Inválidos: %d", NUM_CODIGOS - validos);

	}
	
	public static boolean tieneFormatoValido(String codigo) {
		return codigo.matches("[A-Z]{6}-\\d{4}");
	}
	
	public static boolean tieneContenidoValido(String codigo) {
		return codigo.matches("((ZRG)|(HSC)|(TRL))[A-Z]((PQ)|(MD)|(GR))-\\d{4}") &&
				codigo.substring(7)
					.chars()
					.map(c -> Character.getNumericValue(c))
					.reduce(0, Integer::sum) >= 20;
	}

}
