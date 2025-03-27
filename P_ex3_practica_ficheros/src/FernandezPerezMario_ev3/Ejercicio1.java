package FernandezPerezMario_ev3;

import java.io.IOException;
import java.util.List;
import entrada.Teclado;

public class Ejercicio1 {

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Consultar todos los socios del fichero.");
		System.out.println("(2) Insertar un socio en el fichero.");
		System.out.println("(3) Eliminar los socios del fichero que tienen menos de una cantidad dada de puntos.");
		System.out.println();
	}
	
	public static void escribirListaSocios(List<Socio> listaSocios) {
		for (Socio socio : listaSocios) {
			System.out.println(socio.toString());
		}
		System.out.println("Se han consultado " + listaSocios.size() + " socios.");
	}
	
	public static void main(String[] args) {
		int opcion, numeroPuntos, numeroSocios;
		double cuotaMensual;
		String dni, nombre;
		Socio socio;
		List<Socio> listaSocios;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opcion: ");
			try {
				switch (opcion) {
				// Salir del programa.
				case 0:
					break;
					
				// Consultar todos los socios del fichero.
				case 1:
					listaSocios = AccesoFichero.leerTodos();
					if (listaSocios.isEmpty()) {
						System.out.println("No se ha encontrado ningun socio en el fichero.");
					}
					else {
						escribirListaSocios(listaSocios);
					}
					break;
						
				// Insertar un socio en el fichero.
				case 2:
					dni = Teclado.leerCadena("DNI: ");
					socio = AccesoFichero.consultarPorDni(dni);
					if (socio == null) {
						nombre = Teclado.leerCadena("Nombre: ");
						cuotaMensual = Teclado.leerReal("Cuota Mensual: ");
						numeroPuntos = Teclado.leerEntero("Numero de Puntos: ");
						socio = new Socio(dni, nombre, cuotaMensual, numeroPuntos);
						AccesoFichero.insertar(socio);
						System.out.println("Se ha insertado un socio en el fichero.");
					}
					else {
						System.out.println("Se ha encontrado un socio con DNI " + dni + " en el fichero.");
						System.out.println(socio.toString());
					}
					break;
					
				// Eliminar los socios del fichero que tienen menos de una cantidad dada de puntos.
				case 3:
					numeroPuntos = Teclado.leerEntero("Numero de Puntos Maximo: ");
					numeroSocios = AccesoFichero.eliminarPorNumeroPuntos(numeroPuntos);
					if (numeroSocios == 0) {
						System.out.println("No se ha encontrado ningun socio con menos de " + numeroPuntos + " puntos en el fichero.");
					}
					else {
						System.out.println("Se han eliminado " + numeroSocios + " socios del fichero.");
					}
					break;
					
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
				}
								
			}
			catch (IOException excepcion) {
				System.out.println("Error de entrada/salida al acceder al fichero.");
				excepcion.printStackTrace();
			}
		}
		while (opcion != 0);
		System.out.println("Programa finalizado.");
	}

}
