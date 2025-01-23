import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 1;
		Scanner sc = new Scanner(System.in);

		while (numero > 0) {
			System.out.print("¿Número (0 para salir)? ");
			numero = sc.nextInt();
			if (numero > 0) {
				System.out.println("\nEl número " + numero + " tiene " + 
									contarNumeroDivisores(numero) + " divisores.\n");
			}
		}
	}
	
	public static int contarNumeroDivisores(int numero) {
		return contarNumeroDivisoresRecursiva(numero, 1);
	}

	public static int contarNumeroDivisoresRecursiva(int numero, int divisor) {
		if (divisor == numero) {
			System.out.print(divisor + " ");
			return 1;
		}
		if (numero % divisor == 0) {
			System.out.print(divisor + " ");
			return contarNumeroDivisoresRecursiva(numero, divisor+1) + 1;
		} else {
			return contarNumeroDivisoresRecursiva(numero, divisor+1);
		}
	}
}
