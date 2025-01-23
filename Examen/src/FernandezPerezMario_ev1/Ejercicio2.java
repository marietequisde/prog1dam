package FernandezPerezMario_ev1;

import entrada.Teclado;

public class Ejercicio2 {

	public static void main(String[] args) {
		int opcion = 0;
		Rectangulo rectanguloTeclado = null;
		Rectangulo rectanguloRandom = null;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				rectanguloTeclado = crearRectanguloTeclado();
				break;
			case 2:
				rectanguloRandom = crearRectanguloRandom();
				break;
			case 3:
				escribirRectangulos(rectanguloTeclado, rectanguloRandom);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}
	
	public static Rectangulo crearRectanguloTeclado() {
		int anchura, altura;
		
		do {
			anchura = Teclado.leerEntero("Anchura: ");
			altura = Teclado.leerEntero("Altura: ");
			
			if (!Rectangulo.sonValidas(anchura, altura)) {
				System.out.println("La anchura debe ser positiva.");
				System.out.println("La altura debe ser positiva.");
			}
		} while (!Rectangulo.sonValidas(anchura, altura));

		System.out.println("Se ha creado un rectángulo con datos leídos por teclado.");
		return new Rectangulo(anchura, altura);
		
	}
	
	public static Rectangulo crearRectanguloRandom() {
		System.out.println("Se ha creado un rectángulo con datos generados de forma aleatoria.");
		return new Rectangulo();
	}
	
	public static void escribirRectangulos(Rectangulo rectanguloTeclado, Rectangulo rectanguloRandom) {
		if (rectanguloTeclado != null) {
			System.out.println("\nRectángulo Teclado:");
			System.out.printf(rectanguloTeclado.toString());
		} else {
			System.out.println("No se ha creado ningún rectángulo con datos leídos por teclado.");
		}
		
		if (rectanguloRandom != null) {
			System.out.println("Rectángulo Aleatorio:");
			System.out.printf(rectanguloRandom.toString());
		} else {
			System.out.println("No se ha creado ningún rectángulo con datos generados de forma aleatoria.");
		}
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.\n"
						 + "(1) Crear un rectángulo con datos leídos por teclado.\n"
						 + "(2) Crear un rectángulo con datos generados de forma aleatoria.\n"
						 + "(3) Escribir en consola los dos rectángulos.");
	}

}
