package Actividades3;

import java.util.Scanner;

public class Actividad3x01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int anyo;
		
		System.out.printf("¿Año? ");
		anyo = sc.nextInt();
		
		if (anyo < 1583) {
			System.err.println("El año debe ser mayor o igual que 1583.");
		} else if (anyo % 4 == 0 && (anyo % 100 > 0 || anyo % 400 == 0)) {
			System.out.printf("El año %d es bisiesto.", anyo);
		} else {
			System.out.printf("El año %d es bisiesto.", anyo);
		}
		
		sc.close();
	}

}
