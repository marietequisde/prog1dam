import java.util.Scanner;

public class Actividad1x06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numChicos, numChicas;
		
		System.out.printf("¿Número de Chicos? ");
		numChicos = sc.nextInt();
		
		System.out.printf("¿Número de Chicas? ");
		numChicas = sc.nextInt();
		
		int total = numChicas + numChicos;
		double porcentajeChicos = numChicos * 100.0 / total;
		double porcentajeChicas = numChicas * 100.0 / total;
		
		System.out.printf("Porcentaje de Chicos: %.2f%%\n", porcentajeChicos);
		System.out.printf("Porcentaje de Chicas: %.2f%%", porcentajeChicas);

		sc.close();
	}

}
