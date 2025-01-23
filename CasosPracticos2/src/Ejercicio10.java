import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio10 {

	public static final double CUOTA_MINIMA = 2.0;
	public static final double HORAS_CUOTA_MINIMA = 3.0;
	public static final double CARGO_HORA = 0.5;
	public static final double CARGO_MAX = 10.0;
	public static final double HORAS_MAX = 24.0;

	public static void main(String[] args) {
		int conductores;
		DecimalFormat df = new DecimalFormat("#.00");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿Número de Conductores? ");
		conductores = sc.nextInt();
		for (int i = 1; i <= conductores; i++) {
			double horas;
			
			System.out.println("\nCONDUCTOR " + i + ":");
			System.out.print("¿Tiempo en Horas? ");
			horas = sc.nextDouble();
			
			if (horas <= 0 || horas > HORAS_MAX) {
				System.err.println("El tiempo debe estar comprendido entre 0 y 24 horas.");
			} else {
				String cargo = df.format(calcularCargoPorEstacionar(horas));
				System.out.println("Cargo por Estacionar: " + cargo +" euros");
			}
		}
		sc.close(); 
	}

	public static double calcularCargoPorEstacionar(double horas) {
		horas = Math.ceil(horas);
		return minimo(
					  CUOTA_MINIMA + 
					  ((horas > HORAS_CUOTA_MINIMA) ? (horas - HORAS_CUOTA_MINIMA) * CARGO_HORA : 0)
					  ,CARGO_MAX);
	}

	public static double minimo(double numA, double numB) {
		return numA < numB ? numA : numB;
	}

}
