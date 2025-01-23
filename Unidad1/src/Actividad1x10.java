import java.util.Scanner;

public class Actividad1x10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radio, altura;
		
		System.out.printf("¿Radio del Cilindro (en metros)? ");
		radio = sc.nextDouble();
		System.out.printf("¿Altura del Cilindro (en metros)? ");
		altura = sc.nextDouble();
		
		double volumen = Math.PI * Math.pow(radio, 2) * altura;
		double area = 2 * Math.PI * radio * (altura + radio);
		
		System.out.printf("Área del Cilindro: %.3f metros cuadrados\n", area);
		System.out.printf("Volumen del Cilindro: %.3f metros cúbicos", volumen);

		sc.close();
	}

}
