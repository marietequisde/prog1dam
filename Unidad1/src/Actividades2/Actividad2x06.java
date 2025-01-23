package Actividades2;

import java.util.Scanner;

public class Actividad2x06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int segundosTotales;
		
		System.out.printf("¿Tiempo en Segundos? ");
		segundosTotales = sc.nextInt();
		
		if (segundosTotales < 0) {
			System.err.println("El tiempo en segundos debe ser "
								+ "mayor o igual que 0.");
		} else {
			int horas, minutos, segundos;
			horas = segundosTotales / 3600;
			minutos = (segundosTotales % 3600) / 60;
			segundos = (segundosTotales % 3600) % 60;
			System.out.printf("%d horas %d minutos %d segundos", 
								horas, minutos, segundos);
		}

		sc.close();
	}

}
