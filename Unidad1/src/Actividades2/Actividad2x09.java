package Actividades2;

import java.util.Scanner;

public class Actividad2x09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double coA, coB, coC;
		
		System.out.printf("¿Coeficiente A? ");
		coA = sc.nextDouble();
		if (coA == 0) {
			System.err.println("El coeficiente A debe ser distinto de 0.");
		} else { 
			System.out.printf("¿Coeficiente B? ");
			coB = sc.nextDouble();
			
			System.out.printf("¿Coeficiente C? ");
			coC = sc.nextDouble();
			
			double discriminante = coB*coB -4*coA*coC;
			
			if (discriminante > 0) {
				System.out.println("La ecuación tiene dos soluciones reales:");
				double solA = (-coB + Math.sqrt(discriminante)) / (2*coA);
				double solB = (-coB - Math.sqrt(discriminante)) / (2*coA);
				System.out.printf("X1 = %.1f\nX2 = %.1f", solA, solB);	
			} else if (discriminante < 0) {
				System.out.println("La ecuación no tiene ninguna solución real.");
			} else {
				System.out.println("La ecuación tiene una única solución real:");
				System.out.printf("X = %.1f", -coB / (2*coA));	
			}
		}
		
		sc.close();
	}

}
