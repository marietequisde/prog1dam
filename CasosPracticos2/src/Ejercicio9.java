import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio9 {

	public static void main(String[] args) {
		int numA;
		int numB;
		int numC;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("¿Primer Número? ");
			numA = sc.nextInt();
			System.out.print("¿Segundo Número? ");
			numB = sc.nextInt();
			
			if (numA > 0 && numB > 0) {
				System.out.println("Máximo Común Divisor de " + numA + " y " + numB + ": " + 
									calcularMaximoComunDivisor(numA, numB));
				System.out.println("Mínimo Común Múltiplo de " + numA + " y " + numB + ": " + 
						calcularMinimoComunMultiplo(numA, numB));
			} else {
				System.err.println("Los dos números deben ser positivos.");
			}
			
			System.out.print("¿Desea procesar otro par de números (0 para salir)? ");
			numC = sc.nextInt();
			System.out.println();
		} while (numC != 0);


	}

	public static int calcularMaximoComunDivisor(int numA, int numB) {
        return IntStream.rangeClosed(1, numA)
        		.map(i -> numA + 1 - i)
				.filter(num -> esDivisor(numA, num) && esDivisor(numB, num))
				.findFirst().orElse(1);
	}
	
	public static int calcularMinimoComunMultiplo(int numA, int numB) {
        return (numA * numB) / calcularMaximoComunDivisor(numA, numB);
	}

	public static boolean esDivisor(int a, int b) {
		return a % b == 0;
	}

}
