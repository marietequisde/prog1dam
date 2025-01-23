package Actividades2;

import java.util.Scanner;

public class Actividad2x08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double coA, coB;
		
		System.out.printf("¿Coeficiente A? ");
		coA = sc.nextDouble();
		if (coA == 0) {
			System.err.println("El coeficiente A debe ser distinto de 0.");
		} else { 
			System.out.printf("¿Coeficiente B? ");
			coB = sc.nextDouble();
			
			System.out.println("La ecuación tiene una solución real:");
			System.out.printf("X = %.1f", -coB / coA);
		}
		
		sc.close();

	}

}
