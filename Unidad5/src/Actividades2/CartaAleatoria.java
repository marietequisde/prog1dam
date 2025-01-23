package Actividades2;

import java.util.Random;

import entrada.Teclado;

public class CartaAleatoria {

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menu();
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println(obtenerCartaAleatoria());
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 1.");
				break;
			}
			
		} while (opcion != 0);
	}

	public static int menu() {
		return Teclado.leerEntero("0) Salir del programa.\r\n"
								+ "1) Extraer una carta de la baraja española (con reemplazamiento) y visualizarla en la consola.\r\n"
								+ "¿Opción (0-1)? ");
	}
	
	public static String obtenerCartaAleatoria() {
		return obtenerNumeroCartaAleatorio() + " de " + obtenerPaloAleatorio();
	}
	
	public static int obtenerNumeroCartaAleatorio() {
		Integer[] cartas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
		return obtenerPosicionAleatoria(cartas);
	}
	
	public static String obtenerPaloAleatorio() {
		String[] palos = {"oros", "copas", "espadas", "bastos"};
		return obtenerPosicionAleatoria(palos);
	}
	
	public static <T> T obtenerPosicionAleatoria(T[] vector) {
		Random aleatorio = new Random();
		int pos = aleatorio.nextInt(vector.length);
		return vector[pos];
	}
}
