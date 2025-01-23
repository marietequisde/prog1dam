package Actividades3;

import entrada.Teclado;

public class Actividad3x01 {
	
	public final static String COD_FIN = "000000";

	public static void main(String[] args) {
		String codigo;
		int hP = 0;
		int mP = 0;
		int hS = 0;
		int mS = 0;
		
		do {
			codigo = Teclado.leerCadena("¿Código de Alumno (" + COD_FIN + " para salir)? ");
			if (!COD_FIN.equals(codigo)) {
				if (esValido(codigo)) {
					System.out.println("El Código de Alumno es válido.");
					if (esHombrePrimero(codigo)) {
						hP++;
					} else if (esMujerPrimero(codigo)) {
						mP++;
					} else if (esHombreSegundo(codigo)) {
						hS++;
					} else if (esMujerSegundo(codigo)) {
						mS++;
					}
					
				} else {
					System.out.println("El Código de Alumno no es válido.");
				}
			}
		} while (!COD_FIN.equals(codigo));

		System.out.printf("Códigos Válidos: %d\n", hP + mP + hS + mS);
		System.out.printf("Alumnos Hombres en Primero: %d\n", hP);
		System.out.printf("Alumnos Mujeres en Primero: %d\n", mP);
		System.out.printf("Alumnos Hombres en Segundo: %d\n", hS);
		System.out.printf("Alumnos Mujeres en Segundo: %d\n", mS);
	}
	
	public static boolean esValido(String codigo) {
		return codigo.matches("199[0-5][1-2][HM]");
	}
	
	public static boolean esHombrePrimero(String codigo) {
		return codigo.matches("199[0-5][1][H]");
	}
	
	public static boolean esMujerPrimero(String codigo) {
		return codigo.matches("199[0-5][1][M]");
	}
	
	public static boolean esHombreSegundo(String codigo) {
		return codigo.matches("199[0-5][2][H]");
	}
	
	public static boolean esMujerSegundo(String codigo) {
		return codigo.matches("199[0-5][2][M]");
	}
	

}
