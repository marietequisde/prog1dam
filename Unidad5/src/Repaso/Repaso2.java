package Repaso;

import java.util.Arrays;
import java.util.Random;

public class Repaso2 {
	
	public static void main(String[] args) {
		int[] vector = generarVector(100, 1000, 9999);
		int numCapicuas = 0;
		
		Arrays.sort(vector);
		for (int i = vector.length-1; i >= 0; i--) {
			int num = vector[i];
			if (esCapicua(num)) {
				System.out.println(num);
				numCapicuas++;
			}
		}
		
		System.out.println("Número de capicuas: " + numCapicuas);

	}
	
	public static int[] generarVector(int capacidad, int minimo, int maximo) {
		Random aleatorio = new Random();
		int[] vector = new int[capacidad];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
		}
		
		return vector;
	}
	
	private static boolean esCapicua(int numero) {
		String numeroStr = String.valueOf(numero);
		boolean capicua = true;
		int largo = numeroStr.length();
		
		for (int i = 0; i < largo; i++) {
			if (numeroStr.charAt(i) != numeroStr.charAt(largo-1	-i)) {
				capicua = false;
			}
		}
		
		return capicua;
	}

}
