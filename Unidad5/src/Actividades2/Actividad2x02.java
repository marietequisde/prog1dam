package Actividades2;

import java.util.Random;

import entrada.Teclado;

public class Actividad2x02 {

	public static void main(String[] args) {
		int[][] matriz = new int[8][8];
		generarMatrizAleatoria(matriz, 1, 100);
		System.out.println("MATRIZ:");
		escribirMatriz(matriz);
		System.out.println();
		
		for (int i = 0; i < matriz.length; i++) {
			int sumFila = 0;
			for (int y = 0; y < matriz[0].length; y++) {
				sumFila += matriz[i][y];
			}
			System.out.printf("Suma de Fila %d: %d\n", i, sumFila);
		}
		
		System.out.println();
		
		for (int i = 0; i < matriz.length; i++) {
			int sumColumna = 0;
			for (int y = 0; y < matriz[0].length; y++) {
				sumColumna += matriz[y][i];
			}
			System.out.printf("Suma de Columna %d: %d\n", i, sumColumna);
		}

	}
	
	public static void generarMatrizAleatoria(int[][] matriz, int min, int max) {
		Random aleatorio = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int y = 0; y < matriz[0].length; y++) {
				matriz[i][y] = aleatorio.nextInt(max - min + 1) + min;
			}
		}
	}
	
	public static void escribirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("[");
			for (int y = 0; y < matriz[0].length; y++) {
				System.out.printf("%4d", matriz[i][y]);
				if (y != matriz[0].length - 1) {
					System.out.printf(",");
				}
			}
			System.out.printf("]\n");
		}
	}

}
