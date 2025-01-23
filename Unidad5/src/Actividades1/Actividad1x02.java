package Actividades1;

import java.util.Arrays;

import entrada.Teclado;

public class Actividad1x02 {

	public static void main(String[] args) {
		int[] vectorA, vectorB, vectorSuma, vectorProducto;
		
		System.out.println("VECTOR A:");
		vectorA = leerVector(10);
		
		System.out.println("\nVECTOR B:");
		vectorB = leerVector(10);
		
		vectorSuma = sumarVectores(vectorA, vectorB);
		vectorProducto = multiplicarVectores(vectorA, vectorB);
		
		System.out.println("\nVECTOR A:");
		System.out.println(Arrays.toString(vectorA));
		System.out.println("VECTOR B:");
		System.out.println(Arrays.toString(vectorB));
		System.out.println("VECTOR SUMA:");
		System.out.println(Arrays.toString(vectorSuma));
		System.out.println("VECTOR PRODUCTO:");
		System.out.println(Arrays.toString(vectorProducto));
	}
	
	public static int[] leerVector(int longitud) {
		int[] vector = new int[longitud];
		
		for (int i = 0; i < longitud; i++) {
			vector[i] = Teclado.leerEntero("¿Número Entero " + i + "? ");
		}
		
		return vector;
	}
	
	public static int[] sumarVectores(int[] vectorA, int[] vectorB) {
		int[] vectorSuma = new int[vectorA.length];
		
		for (int i = 0; i < vectorSuma.length; i++) {
			vectorSuma[i] = vectorA[i] + vectorB[i];
		}
		
		return vectorSuma;
	}
	
	public static int[] multiplicarVectores(int[] vectorA, int[] vectorB) {
		int[] vectorSuma = new int[vectorA.length];
		
		for (int i = 0; i < vectorSuma.length; i++) {
			vectorSuma[i] = vectorA[i] * vectorB[i];
		}
		
		return vectorSuma;
	}

}
