package Actividades2;

import java.util.Scanner;

public class Actividad2x01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.printf("Introduca un número entero: ");
		numero = sc.nextInt();
		
		if (numero % 2 == 0) {
			System.out.println("El número es par");
		} else {
			System.out.println("El número es impar");
		}
		
		if (numero % 5 == 0) {
			System.out.println("El número es múltiplo de 5");
		} else {
			System.out.println("El número no es múltiplo de 5");
		}
		
		sc.close();

	}

}
