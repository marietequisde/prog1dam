package Actividades2;

import java.util.Scanner;

public class Actividad2x10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double importeCaja;
		
		System.out.printf("¿Importe de la Compra? ");
		importeCaja = sc.nextDouble();
		
		if (importeCaja <= 0) {
			System.err.println("El importe de la compra debe ser positivo.");
		} else {
			double importeFinal;
			double rebaja = 0;
			if (importeCaja < 200) {
				rebaja = 0;
			} else if (importeCaja >= 200 && importeCaja <= 800) {
				rebaja = importeCaja * 0.1;
			} else {
				rebaja = importeCaja * 0.15;
			}
			importeFinal = importeCaja - rebaja;
			System.out.printf("Rebaja: %21.2f euros\n", rebaja);
			System.out.printf("Importe con descuento: %.2f euros", importeFinal);
		}
		
		sc.close();

	}

}
