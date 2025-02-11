package actividades.actividad1x03;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import entrada.Teclado;

public class Actividad_2x03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Libro> libros = new ArrayList<>();
		datosPrueba(libros);
		int opcion = 0;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarLibro(libros);
				break;
			case 2:
				eliminarLibro(libros);
				break;
			case 3:
				consultarPorIsbn(libros);
				break;
			case 4:
				consultarTodos(libros);
				break;
			case 5:
				consultarTodosPrecioDesc(libros);
				break;
			case 6:
				consultarTodosEscritor(libros);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 6.");
				break;
			}
			System.out.println();
		} while (opcion != 0);

	}
	
	public static void consultarPorIsbn(List<Libro> libros) {
		Libro libro = null;
		String isbn = Teclado.leerCadena("ISBN: ");
		boolean encontrado = false;
		
		for (int i = 0; i < libros.size() && !encontrado; i++) {
			libro = libros.get(i);
			if (libro.getIsbn().equals(isbn)) {
				encontrado = true;
			}
		}
		
		if (encontrado) {
			System.out.println(libro.toString());
		} else {
			System.out.println("No existe ningún libro con ese ISBN en la lista.");
		}
	}
	
	public static void consultarTodos(List<Libro> libros) {
		if (!libros.isEmpty()) {
			for (int i = 0; i < libros.size(); i++) {
				System.out.printf("(%d) %s\n", i, libros.get(i).toString());
			}
			System.out.printf("Se han consultado %d libros de la lista.\n", libros.size());
		} else {
			System.out.println("La lista está vacía.");
		}
	}
	
	public static void consultarTodosPrecioDesc(List<Libro> libros) {
		List<Libro> listaAux = new ArrayList<Libro>(libros);
		listaAux.sort(new ComparadorPrecio());
		consultarTodos(listaAux);
	}
	
	public static void consultarTodosEscritor(List<Libro> libros) {
		String escritor = Teclado.leerCadena("Escritor: ");
		int numResultados = 0;
		for (int i = 0; i < libros.size(); i++) {
			Libro libro = libros.get(i);
			if (libro.getEscritor().equals(escritor)) {
				System.out.printf("(%d) %s\n", i, libro.toString());
				numResultados++;
			}
		}
		
		if (numResultados > 0) {
			System.out.printf("Se han consultado %d libros de la lista.\n", numResultados);
		} else {
			System.out.println("No existe ningún libro con ese escritor en la lista.");
		}
		

	}
	
	public static void eliminarLibro(List<Libro> libros) {
		String isbn = Teclado.leerCadena("ISBN: ");
		boolean eliminado = false;
		
//		eliminado = libros.remove(new Libro(isbn));
		
		Iterator<Libro> it = libros.iterator();
		Libro libro = null;
		while(it.hasNext()) {
			libro = it.next();
			if (libro.getIsbn().equals(isbn)) {
				it.remove();
				eliminado = true;
			}
		}
		
		if (eliminado) {
			System.out.println("Se ha eliminado el libro de la lista.");
		} else {
			System.out.println("No existe ningún libro con ese ISBN en la lista.");
		}
	}
	
	public static void insertarLibro(List<Libro> libros) {
		String isbn = Teclado.leerCadena("ISBN: ");
		String titulo = Teclado.leerCadena("Título: ");
		String escritor = Teclado.leerCadena("Escritor: ");
		int anyoPublicacion = Teclado.leerEntero("Año de publicación: ");
		int numUnidades = Teclado.leerEntero("Número de unidades: ");
		double precio = Teclado.leerReal("Precio: ");
		
		Libro libro = new Libro(isbn, titulo, escritor, anyoPublicacion, numUnidades, precio);
		
		if (!libros.contains(libro)) {
			libros.add(libro);
			System.out.println("Se ha insertado el libro en la lista.");
		} else {
			System.out.println("Ya existe otro libro con ese ISBN en la lista.");
		}
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un libro en la lista.");
		System.out.println("(2) Eliminar un libro, por ISBN, de la lista.");
		System.out.println("(3) Consultar un libro, por ISBN, de la lista.");
		System.out.println("(4) Consultar todos los libros de la lista.");
		System.out.println("(5) Consultar todos los libros de la lista, en orden por precio descendente.");
		System.out.println("(6) Consultar varios libros, por escritor, de la lista");
	}
	
	public static void datosPrueba(List<Libro> libros) {
		libros.add(new Libro("0123456789", "The Hobbit", "J.R.R. Tolkien", 1938, 40, 19.75));
		libros.add(new Libro("3456789012", "The Lord of the Rings", "J.R.R. Tolkien", 1955, 25, 59.90));
		libros.add(new Libro("6789012345", "Dune", "Frank Herbert", 1965, 30, 24.95));
		
	}

}
