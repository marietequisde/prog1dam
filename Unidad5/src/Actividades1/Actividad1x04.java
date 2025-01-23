package Actividades1;

import java.util.Arrays;
import java.util.Random;

public class Actividad1x04 {

	public static void main(String[] args) {
		final int LONGITUD = 15;
		double media = 0;
		int inferiores = 0;
		int iguales = 0;
		int superiores = 0;
		int[] vector = generarVectorAleatorio(LONGITUD, -10, 10);
		
		System.out.println("VECTOR:");
		System.out.println(Arrays.toString(vector));
		
		for (int i = 0; i < vector.length; i++) {
			media += vector[i];
		}
		media /= LONGITUD;
		
		for (int i = 0; i < vector.length; i++) {
			int num = vector[i];
			if (num < media) {
				inferiores++;
			} else if (num == media) {
				iguales++;
			} else {
				superiores++;
			}
		}
		
		System.out.println("Media: " + media);
		System.out.println("Número de Elementos Inferiores a la Media: " + inferiores);
		System.out.println("Número de Elementos Iguales a la Media: " + iguales);
		System.out.println("Número de Elementos Superiores a la Media: " + superiores);
	}
	
	public static int[] generarVectorAleatorio(int longitud, int min, int max) {
		Random aleatorio = new Random();
		int[] vector = new int[longitud];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(max - min + 1) + min;
		}
		
		return vector;
	}

}
