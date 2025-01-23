package Actividades3;

import entrada.Teclado;

public class Actividad3x02 {

	public static final int NUM_PRODUCTOS = 10;
	
	public static void main(String[] args) {
		String codigo;
		int aA = 0;
		int iA = 0;
		int aB = 0;
		int iB = 0;
		int aC = 0;
		int iC = 0;
		
		for (int i = 1; i <= NUM_PRODUCTOS; i++) {
			codigo = Teclado.leerCadena("¿Código de Producto " + i + "? ");
			if (esValido(codigo)) {
				System.out.println("El Código de Producto es válido.");
				char categoria = obtenerCategoria(codigo);
				boolean activo = estaActivo(codigo);
				switch (categoria) {
					case 'A':
						if (activo) {
							aA++;
						} else {
							iA++;
						}
						break;
					case 'B':
						if (activo) {
							aB++;
						} else {
							iB++;
						}
						break;
					case 'C':
						if (activo) {
							aC++;
						} else {
							iC++;
						}
						break;
	
					default:
						break;
				}
				
			} else {
				System.out.println("El Código de Producto no es válido.");
			}
		}

		System.out.printf("\nCódigos Válidos: %d\n", aA + iA + aB + iB + aC + iC);
		System.out.printf("Productos Activos en Categoría A: %d\n", aA);
		System.out.printf("Productos Inactivos en Categoría A: %d\n", iA);
		System.out.printf("Productos Activos en Categoría B: %d\n", aB);
		System.out.printf("Productos Inactivos en Categoría B: %d\n", iB);
		System.out.printf("Productos Activos en Categoría C: %d\n", aC);
		System.out.printf("Productos Inactivos en Categoría C: %d\n", iC);

	}
	
	public static boolean esValido(String codigo) {
		return codigo.matches("[ABC]((19[89][0-9])|(201[0-9])|(2020))[10]..");
	}
	
	public static boolean estaActivo(String codigo) {
		return '1' == codigo.charAt(5);
	}
	
	public static char obtenerCategoria(String codigo) {
		return codigo.charAt(0);
	}

}
