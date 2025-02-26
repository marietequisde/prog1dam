package actividades1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad_1x01 {

	public static void main(String[] args) {

		try {
			short dividendo = solicitarEnteroCorto("¿Dividendo? ", 3);
			short divisor = solicitarEnteroCorto("¿Divisor? ", 3);

			int cociente = dividendo / divisor;
			int resto = dividendo % divisor;

			if (resto == 0) {
				System.out.printf("%d es divisible entre %d.\n", dividendo, divisor);
			} else {
				System.out.printf("%d no es divisible entre %d.\n", dividendo, divisor);
			}
			System.out.printf("Cociente: %d\nResto: %d", cociente, resto);
		} catch (ArithmeticException e) {
			System.out.println("Se ha producido un error aritmético.");
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println("Se ha producido un error de entrada/salida.");
			System.out.println(e.toString());
		}

	}

	public static String solicitarCadena(String mensaje) throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf(mensaje);
		return teclado.readLine();
	}

	public static short solicitarEnteroCorto(String mensaje, int numMaxErrores) throws IOException {
		int numErrores = 0;

		while (numErrores <= numMaxErrores) {
			try {
				return Short.parseShort(solicitarCadena(mensaje));
			} catch (NumberFormatException e) {
				numErrores++;
				System.out.println("El dato introducido no tiene formato de número entero corto.");
				System.out.println(e.toString());
				System.out.println("Error número " + numErrores + ".");

			}
		}

		System.out.println("Se ha superado el número de errores permitidos, que es " + numMaxErrores);
		return 0;

	}

}
