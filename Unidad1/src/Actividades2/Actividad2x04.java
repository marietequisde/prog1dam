package Actividades2;

import java.util.Scanner;

public class Actividad2x04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double numA, numB;
		
		System.out.printf("¿Número Real A?: ");
		numA = sc.nextDouble();
		
		System.out.printf("¿Número Real B?: ");
		numB = sc.nextDouble();
		
		if (numA == numB) {
			System.out.printf("Los números reales %.1f y "
								+ "%.1f son iguales.", numA, numB);
		} else {
			double mayor = numA > numB ? numA : numB;
			double menor = numA < numB ? numA : numB;
			System.out.printf("El número real %.1f es el menor y el número "
								+ "real %.1f es el mayor.", menor, mayor);
		}
		
		sc.close();

	}

}
