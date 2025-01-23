package Repaso;

import java.util.Arrays;
import java.util.Random;

public class Repaso1 {

	public static void main(String[] args) {
		int[] vector = generarVector(20, 1, 100);
		int numPrimos = 0;
		
		Arrays.sort(vector);
		for (int i = 0; i < vector.length; i++) {
			int num = vector[i];
			if (esPrimo(num)) {
				System.out.println(num);
				numPrimos++;
			}
		}
		
		System.out.println("Número de primos: " + numPrimos);

	}
	
	public static int[] generarVector(int capacidad, int minimo, int maximo) {
		Random aleatorio = new Random();
		int[] vector = new int[capacidad];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
		}
		
		return vector;
	}
	
	public static boolean esPrimo(int numero) {
		return contarNumeroDivisores(numero) == 2;
	}
	
	private static int contarNumeroDivisores(int numero) {
		return contarNumeroDivisoresRecursiva(numero, 1);
	}

	private static int contarNumeroDivisoresRecursiva(int numero, int divisor) {
		if (divisor == numero) {
			return 1;
		}
		if (numero % divisor == 0) {
			return contarNumeroDivisoresRecursiva(numero, divisor+1) + 1;
		} else {
			return contarNumeroDivisoresRecursiva(numero, divisor+1);
		}
	}

}
