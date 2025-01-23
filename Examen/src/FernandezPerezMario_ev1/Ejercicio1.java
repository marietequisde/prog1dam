package FernandezPerezMario_ev1;

import entrada.Teclado;

public class Ejercicio1 {

	public static void main(String[] args) {
		int opcion = 0;
		int op1, op2;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			
			switch (opcion) {
			case 0:
				break;
			case 1:
			case 2:
				op1 = Teclado.leerEntero("Operando 1: ");
				op2 = Teclado.leerEntero("Operando 2: ");
				System.out.println("El resultado de la operación es: " + calcular(opcion, op1, op2));
				break;
			case 3:
				op1 = Teclado.leerEntero("Operando 1: ");
				op2 = Teclado.leerEntero("Operando 2: ");
				if (op2 > 0) {
					System.out.println("El resultado de la operación es: " + calcular(opcion, op1, op2));
				} else {
					System.out.println("El operando 2 debe ser positivo.");
				}
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.\n"
						 + "(1) Sumar dos números.\n"
						 + "(2) Multiplicar dos números.\n"
						 + "(3) Obtener el resto de la división de un número entre otro.");
	}
	
	public static int calcular(int operacion, int numA, int numB) {
		int resultado = -1;
		
		switch (operacion) {
		case 1:
			resultado = numA + numB;
			break;
		case 2:
			resultado = numA * numB;
			break;
		case 3:
			resultado = numA % numB;
		default:
			break;
			
		}
		
		return resultado;
	}

}
