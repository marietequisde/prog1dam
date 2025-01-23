import java.util.Scanner;

public class Actividad1x11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radio;
		
		System.out.printf("¿Radio de la Esfera (en metros)? ");
		radio = sc.nextDouble();
		
		double area = 4 * Math.PI * Math.pow(radio, 2);
		double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
		
		System.out.printf("Área de la esfera: %.3f metros cuadrados\n", area);
		System.out.printf("Volumen de la esfera: %.3f metros cúbicos", volumen);

		sc.close();
	}

}
