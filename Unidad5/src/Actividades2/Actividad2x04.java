package Actividades2;

import java.util.Random;

import entrada.Teclado;

public class Actividad2x04 {

	public static void main(String[] args) {
		int numAlumnos = 0;
		int numAsignaturas = 0;
		double[][] notas;
		int opcion;
		double media;
		
		numAlumnos = Teclado.leerEntero("¿Número de Alumnos? ");
		numAsignaturas = Teclado.leerEntero("¿Número de Asignaturas? ");
		System.out.println();
		
		notas = generarMatrizAleatoria(numAlumnos, numAsignaturas, 0.0, 10.0);
		
		do {
			opcion = menu();
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				escribirMatriz(notas);
				break;
			case 2:
				int alumno;
				do {
					alumno = Teclado.leerEntero("¿Alumno? ");
					if (alumno < 0 || alumno > (numAlumnos - 1)) {
						System.out.printf("El alumno debe estar comprendido entre 0 y %d.\n", numAlumnos - 1);
					}
				} while (alumno < 0 || alumno > (numAlumnos - 1));
				media = obtenerMediaAlumno(alumno, notas);
				System.out.printf("Media del Alumno %d: %f\n", alumno, media);
				break;
			case 3:
				int asignatura;
				do {
					asignatura = Teclado.leerEntero("¿Asignatura? ");
					if (asignatura < 0 || asignatura > (numAsignaturas - 1)) {
						System.out.printf("La asignatura debe estar comprendida entre 0 y %d.\n", numAsignaturas - 1);
					}
				} while (asignatura < 0 || asignatura > (numAsignaturas - 1));
				media = obtenerMediaAsignatura(asignatura, notas);
				System.out.printf("Media de la Asignatura %d: %f\n", asignatura, media);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
				break;
			}
			
		} while (opcion != 0);

	}
	
	public static double obtenerMediaAsignatura(int asignatura, double[][] notas) {
		double media = 0;
		for (int i = 0; i < notas.length; i++) {
			media += notas[i][asignatura];
		}
		return media / notas.length;
	}
	
	public static double obtenerMediaAlumno(int alumno, double[][] notas) {
		double media = 0;
		for (int i = 0; i < notas[alumno].length; i++) {
			media += notas[alumno][i];
		}
		return media / notas[alumno].length;
	}
	
	public static int menu() {
		return Teclado.leerEntero("(0) Salir del programa.\r\n"
				+ "(1) Visualizar en consola la matriz de notas.\r\n"
				+ "(2) Leer por teclado un alumno y visualizar en consola la media de este alumno.\r\n"
				+ "(3) Leer por teclado una asignatura y visualizar en consola la media de esta asignatura.\r\n"
				+ "¿Opción (0-3)? ");
	}
	
	public static double[][] generarMatrizAleatoria(int filas, int columnas, 
													double min, double max) {
		double[][] matriz = new double[filas][columnas];
		Random aleatorio = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int y = 0; y < matriz[0].length; y++) {
				matriz[i][y] = aleatorio.nextDouble(max) + min;
			}
		}
		return matriz;
	}

	public static void escribirMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("[");
			for (int y = 0; y < matriz[0].length; y++) {
				System.out.printf("%6.2f", matriz[i][y]);
				if (y != matriz[0].length - 1) {
					System.out.printf(";");
				}
			}
			System.out.printf("]\n");
		}
	}
}
