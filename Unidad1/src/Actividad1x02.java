import java.util.Scanner;

public class Actividad1x02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numA, numB, numC;
		
		System.out.println("¿Número Entero A? ");
		numA = sc.nextInt();
		
		System.out.println("¿Número Entero B? ");
		numB = sc.nextInt();
		
		System.out.println("¿Número Entero C? ");
		numC = sc.nextInt();
		
		System.out.println("NÚMEROS ENTEROS ALINEADOS POR LA DERECHA:");
		System.out.printf("A =%6d\n", numA);
		System.out.printf("B =%6d\n", numB);
		System.out.printf("C =%6d\n", numC);
		System.out.println("NÚMEROS ENTEROS ALINEADOS POR LA IZQUIERDA:");
		System.out.printf("A = %d\n", numA);
		System.out.printf("B = %d\n", numB);
		System.out.printf("C = %d\n", numC);

		sc.close();
	}

}
