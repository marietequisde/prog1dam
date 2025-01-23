package Actividades2;

import java.util.Scanner;

public class Actividad2x03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double numero;
		
		System.out.printf("¿Número Real? ");
		numero = sc.nextDouble();
		
		if (numero < 0) {
			System.err.println("El número real debe ser mayor o igual que 0.");
		} else {
			System.out.printf("Cuadrado de %s = %s\n", 
								String.valueOf(numero), 
								String.valueOf(numero*numero));
			System.out.printf("Raíz Cuadrada de %s = %s", 
								String.valueOf(numero), 
								Math.sqrt(numero));
		}
		
		sc.close();

	}

}
