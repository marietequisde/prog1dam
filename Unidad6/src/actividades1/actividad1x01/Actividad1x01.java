package actividades1.actividad1x01;

import java.util.Arrays;

import entrada.Teclado;

public class Actividad1x01 {

	public static void main(String[] args) {
		Almacen almacen = new Almacen(3);
		int opcion = 0;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarVideojuego(almacen);
				break;
			case 2:
				eliminarVideojuegoPosicion(almacen);
				break;
			case 3:
				consultarVideojuegoPosicion(almacen);
				break;
			case 4:
				consultarTodos(almacen);
				break;
			case 5:
				consultarPrimeroPorTitulo(almacen);
				break;
			case 6:
				consultarTodosPorTitulo1(almacen);
				break;
			case 7:
				consultarTodosPorTitulo2(almacen);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 7.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}

	private static void consultarTodos(Almacen almacen) {
		System.out.printf(almacen.toString());
	}

	private static void consultarVideojuegoPosicion(Almacen almacen) {
		int posicion = Teclado.leerEntero("Posición: ");
		Videojuego videojuego = almacen.consultar(posicion);
		if (videojuego != null) {
			System.out.println(videojuego.toString());
		} else {
			System.out.println("No se ha encontrado ningún videojuego en la posición del almacén.");
		}
	}

	private static void eliminarVideojuegoPosicion(Almacen almacen) {
		int posicion = Teclado.leerEntero("Posición: ");
		if (almacen.eliminar(posicion)) {
			System.out.println("Se ha eliminado el videojuego del almacén con éxito.");
		} else {
			System.out.println("Error al eliminar: almacén vacío o posición no indica videojuego en el almacén");
		}
	}

	private static void insertarVideojuego(Almacen almacen) {
		String titulo = Teclado.leerCadena("Título: ");
		double precio = Teclado.leerReal("Precio: ");
		if (almacen.insertar(new Videojuego(titulo, precio))) {
			System.out.println("Se ha insertado el videojuego en el almacén con éxito.");
		} else {
			System.out.println("Error al insertar: almacén lleno.");
		}
	}

	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un videojuego en el almacén.");
		System.out.println("(2) Eliminar un videojuego, por posición, del almacén.");
		System.out.println("(3) Consultar un videojuego, por posición, del almacén.");
		System.out.println("(4) Consultar todos los videojuegos del almacén.");
		System.out.println("(5) Consultar un videojuego por título.");
		System.out.println("(6) Consultar videojuegos por título. (Vector videojuegos)");
		System.out.println("(7) Consultar videojuegos por título. (Objeto almacen)");
	}

	private static void consultarPrimeroPorTitulo(Almacen almacen) {
		String titulo = Teclado.leerCadena("Título: ");
		System.out.println(almacen.consultar(titulo).toString());
		
	}
	
	private static void consultarTodosPorTitulo1(Almacen almacen) {
		String titulo = Teclado.leerCadena("Título: ");
		System.out.println(Arrays.toString(almacen.obtenerVideojuegos(titulo)));
	}
	
	private static void consultarTodosPorTitulo2(Almacen almacen) {
		String titulo = Teclado.leerCadena("Título: ");
		System.out.println(almacen.obtenerAlmacen(titulo).toString());
	}
}
