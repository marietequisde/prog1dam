import java.util.Scanner;

public class Actividad1x05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double numA, numB;
		
		System.out.printf("¿Número Real A? ");
		numA = sc.nextDouble();
		
		System.out.printf("¿Número Real B? ");
		numB = sc.nextDouble();
		
		System.out.println("NÚMEROS REALES CON 2 DÍGITOS DECIMALES:");
		System.out.printf("A = %.2f\n", numA);
		System.out.printf("B = %.2f\n", numB);
		
		System.out.println("NÚMEROS REALES CON 1 DÍGITO DECIMAL:");
		System.out.printf("A = %.1f\n", numA);
		System.out.printf("B = %.1f\n", numB);
		
		System.out.println("NÚMEROS REALES CON NINGÚN DÍGITO DECIMAL:");
		System.out.printf("A = %.0f\n", numA);
		System.out.printf("B = %.0f\n", numB);
		
		sc.close();

	}

}
