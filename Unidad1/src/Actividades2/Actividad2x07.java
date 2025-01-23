package Actividades2;

import java.util.Scanner;

public class Actividad2x07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hora;
		
		System.out.printf("¿Hora? ");
		hora = sc.nextInt();
		
		if (hora < 0 || hora > 23) {
			System.err.println("La hora debe estar comprendida entre 0 y 23.");
		} else if (hora > 5 && hora < 13) {
			System.out.println("buenos días");
		} else if (hora > 12 && hora < 21) {
			System.out.println("buenas tardes");
		} else {
			System.out.println("buenas noches");
		}
		
		sc.close();

	}

}
