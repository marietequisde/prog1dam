import java.util.Scanner;

public class Actividad1x08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radio;
		
		System.out.printf("¿Radio del Círculo (en metros)? ");
		radio = sc.nextDouble();
		
		double perimetro = 2 * Math.PI * radio;
		double area = Math.PI * Math.pow(radio, 2);
		
		System.out.printf("Perímetro del Círculo: %.2f metros\n", perimetro);
		System.out.printf("Área del Círculo: %.2f metros cuadrados", area);

		sc.close();
	}

}
