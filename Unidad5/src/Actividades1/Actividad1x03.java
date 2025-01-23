package Actividades1;

import java.util.Arrays;
import java.util.Random;

public class Actividad1x03 {

	public static void main(String[] args) {
		int[] vector = new int[15];
		int negativos = 0;
		int neutros = 0;
		int positivos = 0;
		
		System.out.println("VECTOR:");
		generarVectorAleatorio(vector, -100, 100);
		System.out.println(Arrays.toString(vector));
		
		for (int i = 0; i < vector.length; i++) {
			int num = vector[i];
			if (num < 0) {
				negativos++;
			} else if (num == 0) {
				neutros++;
			} else {
				positivos++;
			}
		}
		
		System.out.println("Número de Elementos Negativos: " + negativos);
		System.out.println("Número de Elementos Neutros: " + neutros);
		System.out.println("Número de Elementos Positivos: " + positivos);

	}

	public static void generarVectorAleatorio(int[] vector, int min, int max) {
		Random aleatorio = new Random();
		for (int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(max - min + 1) + min;
		}
	}
}
