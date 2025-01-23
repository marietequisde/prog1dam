package Actividades2;

import java.util.Arrays;

import entrada.Teclado;

public class Actividad2x01 {

	public static void main(String[] args) {
		int[][] matriz = new int[4][4];
		int[] posMinimo = new int[2];
		int[] posMaximo = new int[2];
		
		leerMatriz(matriz);

		for (int i = 0; i < matriz.length; i++) {
			for (int y = 0; y < matriz[0].length; y++) {
				int valor = matriz[i][y];
				int valorMin = matriz[posMinimo[0]][posMinimo[1]];
				int valorMax = matriz[posMaximo[0]][posMaximo[1]];
				
				if (valor < valorMin) {
					posMinimo[0] = i;
					posMinimo[1] = y;
				}
				if (valor > valorMax) {
					posMaximo[0] = i;
					posMaximo[1] = y;
				}
			}
		}
		
		int valorMin = matriz[posMinimo[0]][posMinimo[1]];
		int valorMax = matriz[posMaximo[0]][posMaximo[1]];
		
		System.out.println("\nMATRIZ:");
		escribirMatriz(matriz);
		System.out.println("Mínimo: " + valorMin);
		System.out.printf("Primera Posición del Mínimo: (%d,%d)\n", 
							posMinimo[0], posMinimo[1]);
		System.out.println("Máximo: " + valorMax);
		System.out.printf("Primera Posición del Máximo: (%d,%d)", 
							posMaximo[0], posMaximo[1]);
	}
	
	public static void leerMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int y = 0; y < matriz[0].length; y++) {
				matriz[i][y] = Teclado.leerEntero(String.format(
									"¿Número Entero (%d,%d)? ", i, y));
			}
		}
	}
	
	public static void escribirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
	}

}
