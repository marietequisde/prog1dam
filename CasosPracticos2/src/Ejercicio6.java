import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroIni = 1;
		int numeroFin = 2;
		Scanner sc = new Scanner(System.in);

		while (numeroIni <= numeroFin && numeroIni > 0 && numeroFin > 0) {
			
			System.out.print("¿Número Inicial? ");
			numeroIni = sc.nextInt();
			System.out.print("¿Número Final? ");
			numeroFin = sc.nextInt();
			
			if (numeroIni <= numeroFin && numeroIni > 0 && numeroFin > 0) {
				visualizarPrimos(numeroIni, numeroFin);
			} else {
				System.out.println("El número inicial debe ser menor o igual que el número final.");
			}
		}
	}
	
	public static void visualizarPrimos(int numeroIni, int numeroFin) {
		int numPrimos = 0;
		while (numeroIni <= numeroFin) {
			if (esPrimo(numeroIni)) {
				System.out.print(numeroIni + " ");
				numPrimos++;
			}
			numeroIni++;
		}
		System.out.println("\nNúmero de primos: " + numPrimos);
	}
	
	public static int contarNumeroDivisores(int numero) {
		return contarNumeroDivisoresRecursiva(numero, 1);
	}

	public static int contarNumeroDivisoresRecursiva(int numero, int divisor) {
		if (divisor == numero) {
			return 1;
		}
		if (numero % divisor == 0) {
			return contarNumeroDivisoresRecursiva(numero, divisor+1) + 1;
		} else {
			return contarNumeroDivisoresRecursiva(numero, divisor+1);
		}
	}
	
	public static boolean esPrimo(int numero) {
		return contarNumeroDivisores(numero) == 2;
	}
}
