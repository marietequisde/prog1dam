package Actividades2;

import java.util.Scanner;

public class Actividad2x05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double numA, numB, numC;
		
		System.out.printf("¿Número Real A?: ");
		numA = sc.nextDouble();
		
		System.out.printf("¿Número Real B?: ");
		numB = sc.nextDouble();
		
		System.out.printf("¿Número Real C?: ");
		numC = sc.nextDouble();
		
		System.out.printf("El número real %s es el menor.\n",
							String.valueOf(
									(numA < numB && numA < numC) ? numA :
									(numB < numA && numB < numC) ? numB :
									numC
							));

		System.out.printf("El número real %s es el mayor.",
				String.valueOf(
						(numA > numB && numA > numC) ? numA :
						(numB > numA && numB > numC) ? numB :
						numC
				));
		
		sc.close();

	}

}
