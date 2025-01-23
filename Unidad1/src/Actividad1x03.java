import java.util.Scanner;

public class Actividad1x03 {

	public static void main(String[] args) {
		int numA, numB, numTmp;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Número Entero A? ");
		numA = sc.nextInt();
		
		System.out.println("¿Número Entero B? ");
		numB = sc.nextInt();
		
		System.out.println("ANTES DEL INTERCAMBIO:");
		System.out.printf("A = %d y B = %d\n", numA, numB);
		
		numTmp = numA;
		numA = numB;
		numB = numTmp;
		
		System.out.println("DESPUÉS DEL INTERCAMBIO:");
		System.out.printf("A = %d y B = %d\n", numA, numB);
		
		sc.close();
	}

}
