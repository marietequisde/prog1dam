
public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10000; i++) {
			if (esPerfecto(i)) {
				System.out.println("El número " + i + " es perfecto.");
			}
		}
		

	}
	
	public static boolean esPerfecto(int numero) {
		return sumarDivisores(numero) == numero;
	}
	
	public static int sumarDivisores(int numero) {
		return sumarDivisoresRecursiva(numero, 1);
	}

	public static int sumarDivisoresRecursiva(int numero, int divisor) {
		if (divisor == numero) {
			return 0;
		}
		if (numero % divisor == 0) {
			return sumarDivisoresRecursiva(numero, divisor+1) + divisor;
		} else {
			return sumarDivisoresRecursiva(numero, divisor+1);
		}
	}

}
