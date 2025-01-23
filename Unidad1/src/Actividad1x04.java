import java.util.Scanner;

public class Actividad1x04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double numA, numB;
		
		System.out.printf("¿Número Real A? ");
		numA = sc.nextDouble();
		
		System.out.printf("¿Número Real B? ");
		numB = sc.nextDouble();
		
		System.out.printf("%.2f + %.2f = " + (numA + numB) + "\n", numA, numB);
		System.out.printf("%.2f - %.2f = " + (numA - numB) + "\n", numA, numB);
		System.out.printf("%.2f * %.2f = " + (numA * numB) + "\n", numA, numB);
		System.out.printf("%.2f / %.2f = " + (numA / numB) + "\n", numA, numB);
		
		sc.close();
	}

}
