package Actividades2;

import java.util.Scanner;

public class Actividad2x02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.printf("Introduca un número entero: ");
		numero = sc.nextInt();
		
		if (numero > 0) {
			System.out.println("El número es positivo");
		} else if (numero == 0) {
			System.out.println("El número es neutro");
		} else {
			System.out.println("El número es negativo");
		}
		
		sc.close();

	}

}
