import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {

		int lado = 49;
		Scanner teclado = new Scanner(System.in);
		
//		do {
//			System.out.println("Introduzca un número mayor que 0");
//			lado = teclado.nextInt();
//		} while (lado < 1);
//			
		generarPiramide(lado);
	}
	
	public static void generarOctogono(int lado) {
		int alto = (lado * 3) - 2;
		String octogono = "";
		int asteriscos = lado;
		for (int i = 0; i < alto; i++) {
			octogono += generarElementos((alto - asteriscos) / 2, "  ");
			octogono += generarElementos(asteriscos, "* ").trim();
			octogono += generarElementos((alto - asteriscos) / 2, "  ") + "\n";
			if (i+2 >= lado*2) {
				asteriscos -= 2;
			} else if (asteriscos < alto) {
				asteriscos += 2;
			}
		}
		System.out.println(octogono);
	}
	
	public static void generarExagono(int lado) {
		int ancho = (lado * 3) - 2;
		int alto = (lado * 2) - 1;
		String exagono = "";
		int asteriscos = lado;
		for (int i = 0; i < alto; i++) {
			exagono += generarElementos((ancho - asteriscos) / 2, "  ");
			exagono += generarElementos(asteriscos, "* ").trim();
			exagono += generarElementos((ancho - asteriscos) / 2, "  ") + "\n";
			if (i+1 >= lado) {
				asteriscos -= 2;
			} else if (asteriscos < ancho) {
				asteriscos += 2;
			}
		}
		System.out.println(exagono);
	}
	
	public static void generarRombo(int numIni) {
		String rombo = "";
		int alto = (numIni * 2) - 1;
		int numCentral = 0;
		for (int i = 0; i < alto; i++) {
			String izquierda = "";
			String derecha = "";
			String espacios = generarElementos(alto/2 - numCentral, "   ");
			
			if (i != 0 && i != alto - 1) {
				izquierda = generarSecuencia(1, numCentral) + "  ";
				derecha = "  " + generarSecuencia(numCentral, 1);
			}
			rombo += espacios + izquierda + (numCentral+1) + derecha + "\n";
			
			if (i+1 < numIni) {
				numCentral++;
			} else {
				numCentral--;
			}
		}
		System.out.println(rombo);
	}
	
	public static void generarPiramide(int numLimite) {
		if (numLimite > 0 && numLimite % 7 == 0) {
			int alto = numLimite / 7;
			final int NUM_LADO = 7;
			String piramide = "";
			
			for (int i = 0; i < alto; i++) {
				String izquierda = "";
				String derecha = "";
				String espacios = generarElementos((alto - (i + 1)) * 3, " ");
				int numCentral = NUM_LADO * (i + 1);
				if (i != 0) {
					izquierda = generarSecuenciaMultiplos(NUM_LADO, numCentral - NUM_LADO) + " ";
					derecha = " " + generarSecuenciaMultiplos(numCentral - NUM_LADO, NUM_LADO);
				}
				piramide += espacios + izquierda + String.format("%02d", numCentral) + derecha + "\n";
			}
			
			System.out.println(piramide);
		} else {
			System.out.println("El número límite del triángulo debe ser positivo y múltiplo de 7.");
		}
	}
	
	public static String generarSecuenciaMultiplos(int ini, int fin) {
		String secuencia = "";
		if (ini > fin) {
			for (int i = ini; i >= fin; i-=7) {
				String numTmp = String.format("%02d", i);
				secuencia = secuencia + numTmp + " ";
			}
		} else {
			for (int i = ini; i <= fin; i+=7) {
				String numTmp = String.format("%02d", i);
				secuencia = secuencia + numTmp + " ";
			}
		}
		return secuencia.trim();
	}
	
	public static String generarSecuencia(int ini, int fin) {
		String secuencia = "";
		if (ini > fin) {
			for (int i = ini; i >= fin; i--) {
				secuencia = secuencia + i + "  ";
			}
		} else {
			for (int i = ini; i <= fin; i++) {
				secuencia = secuencia + i + "  ";
			}
		}
		return secuencia.trim();
	}
	
	public static String generarElementos(int num, String elemento) {
		String retVal = "";
		for (int i = 0; i < num; i++) {
			retVal = retVal + elemento;
		}
		return retVal;
	}
	
	
	

}
