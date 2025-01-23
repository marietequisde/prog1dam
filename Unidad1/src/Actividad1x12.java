import java.util.Scanner;

public class Actividad1x12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double vInicial, a, tiempo;
		
		System.out.printf("¿Velocidad Inicial del Cohete (en metros/segundo)? ");
		vInicial = sc.nextDouble();
		
		System.out.printf("¿Aceleración del Cohete (en metros/segundo*segundo)? ");
		a = sc.nextDouble();
		
		System.out.printf("¿Tiempo transcurrido (en segundos)? ");
		tiempo = sc.nextDouble();

		double distanciaTotal = vInicial*tiempo + 0.5*a*Math.pow(tiempo, 2);
		
		System.out.printf("Distancia recorrida por el Cohete: %.3f metros\n", distanciaTotal);
		
		sc.close();
	}

}
