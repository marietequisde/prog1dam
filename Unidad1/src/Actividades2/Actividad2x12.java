package Actividades2;

import java.util.Scanner;

public class Actividad2x12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dia;
		
		System.out.printf("¿Día de la Semana? ");
		dia = sc.nextInt();
		
		switch (dia) {
		case 1: {
			System.out.println("Lunes");
			break;
		}
		case 2: {
			System.out.println("Martes");
			break;
		}
		case 3: {
			System.out.println("Miércoles");
			break;
		}
		case 4: {
			System.out.println("Jueves");
			break;
		}
		case 5: {
			System.out.println("Viernes");
			break;
		}
		case 6: {
			System.out.println("Sábado");
			break;
		}
		case 7: {
			System.out.println("Domingo");
			break;
		}
		default:
			System.err.println("El día de la semana debe estar comprendido entre 1 y 7.");
		}
	
		sc.close();
	}

}
