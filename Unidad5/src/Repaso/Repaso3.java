package Repaso;

import java.util.Arrays;
import java.util.Random;

public class Repaso3 {

	public static void main(String[] args) {
		int[] vectorA = generarVectorSinRepetidos(5, 0, 10);
		int[] vectorB = generarVectorSinRepetidos(5, 0, 10);
		int[] union = generarVectorUnion(vectorA, vectorB);
		int[] interseccion = generarVectorInterseccion(vectorA, vectorB);
		
		System.out.println("A = " + Arrays.toString(vectorA));
		System.out.println("B = " + Arrays.toString(vectorB));
		System.out.println("Unión = " + Arrays.toString(union));
		System.out.println("Intersección = " + Arrays.toString(interseccion));
		
	}
	
	public static int[] generarVectorSinRepetidos(int capacidad, int minimo, int maximo) {
		Random aleatorio = new Random();
		int[] vector = new int[capacidad];
		
		for (int i = 0; i < vector.length; i++) {
			int numAleatorio;
			do {
				numAleatorio = aleatorio.nextInt(maximo - minimo + 1) + minimo;
			} while (contiene(Arrays.copyOfRange(vector, 0, i), numAleatorio));
			vector[i] = numAleatorio;
		}
		
		return vector;
	}
	
	public static boolean contiene(int[] vector, int elemento) {
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == elemento) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] generarVectorUnion(int[] vectorA, int[] vectorB) {
		int repetidos = contarRepetidos(vectorA, vectorB);
		int[] union = new int[vectorA.length + vectorB.length - repetidos];
		int contador = 0;
		
		for (int i = 0; i < vectorA.length; i++) {
			union[contador++] = vectorA[i];
		}
		
		for (int i = 0; i < vectorB.length; i++) {
			if (!contiene(vectorA, vectorB[i])) {
				union[contador++] = vectorB[i];
			}
		}
		
		return union;
	}
	
	public static int[] generarVectorInterseccion(int[] vectorA, int[] vectorB) {
		int repetidos = contarRepetidos(vectorA, vectorB);
		int[] interseccion = new int[repetidos];
		int contador = 0;
		
		for (int i = 0; i < vectorA.length; i++) {
			if (contiene(vectorB, vectorA[i])) {
				interseccion[contador++] = vectorA[i];
			}
		}
		
		return interseccion;
	}
	
	private static int contarRepetidos(int[] vectorA, int[] vectorB) {
		int repetidos = 0;
		
		for (int i = 0; i < vectorA.length; i++) {
			if (contiene(vectorB, vectorA[i])) {
				repetidos++;
			}
		}
		
		return repetidos;
	}

}
