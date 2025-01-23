package Actividades2;

import java.util.Scanner;

public class Actividad2x11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int turno, hOrdin, hExtra;
		boolean error = false;
		
		System.out.printf("¿Turno de Trabajo (1-diurno, 2-vespertino)? ");
		turno = sc.nextInt();
		
		System.out.printf("¿Número de Horas Ordinarias? ");
		hOrdin = sc.nextInt();
		
		System.out.printf("¿Número de Horas Extraordinarias? ");
		hExtra = sc.nextInt();
		
		if (turno != 1 && turno != 2) {
			error = true;
			System.err.println("El turno de trabajo debe estar comprendido entre 1 y 2.");
		}
		if (hOrdin < 20 || hOrdin > 40) {
			error = true;
			System.err.println("El número de horas ordinarias debe estar comprendido entre 20 y 40.");
		}
		if (hExtra < 0 || hExtra > 5) {
			error = true;
			System.err.println("El número de horas extraordinarias debe estar comprendido entre 0 y 5.");
		}
		if (!error) {
			double salario;
			if (turno == 1) {
				salario = hOrdin * 5.40 + hExtra * 7.25;
			} else {
				salario = hOrdin * 8.60 + hExtra * 11.75;
			}
			System.out.printf("Salario Semanal: %.2f euros", salario);
		}
		
		sc.close();
	}

}
