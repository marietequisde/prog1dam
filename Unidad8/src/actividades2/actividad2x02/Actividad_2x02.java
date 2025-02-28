package actividades2.actividad2x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import actividades2.actividad2x02.excepciones.ExcepcionFecha;

public class Actividad_2x02 {

	public static void main(String[] args) {

		try {
			String cadena = solicitarCadena("¿Fecha? ");
			Fecha fecha = new Fecha(cadena);
			if (fecha.esValida()) {
				System.out.println("Fecha Válida");
			}

		} catch (IOException e) {
			System.out.println("Se ha producido un error de entrada/salida.");
			System.out.println(e.toString());

		} catch (NumberFormatException e) {
			System.out.println("Se ha producido un error de formato de número.");
			System.out.println(e.toString());

		} catch (ExcepcionFecha e) {
			System.out.println("Se ha producido un error de fecha.");
			System.out.println(e.toString());
		}

	}

	public static String solicitarCadena(String mensaje) throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf(mensaje);
		return teclado.readLine();
	}

}
