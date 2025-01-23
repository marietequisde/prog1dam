import java.util.Scanner;

public class Actividad1x07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double base, altura;
		
		System.out.printf("¿Base del Rectángulo (en metros)? ");
		base = sc.nextDouble();
		System.out.printf("¿Altura del Rectángulo (en metros)? ");
		altura = sc.nextDouble();
		
		double perimetro = 2*base + 2*altura;
		double area = base * altura;
		
		System.out.printf("Perímetro del Rectángulo: %.2f metros\n", perimetro);
		System.out.printf("Área del Rectángulo: %.2f metros cuadrados", area);

		sc.close();
	}

}
