package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import amazon.comparadores.ComparadorPeliculaDirector;
import entrada.Teclado;

public class Principal {

	public static void main(String[] args) {
		Set<Producto> productos = new LinkedHashSet<Producto>();
		int opcion = 0;
		datosPrueba(productos);

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarLibro(productos);
				break;
			case 2:
				insertarPelicula(productos);
				break;
			case 3:
				insertarVideojuego(productos);
				break;
			case 10:
				consultarLibros(productos);
				break;
			case 11:
				consultarPeliculas(productos);
				break;
			case 12:
				consultarVideojuegos(productos);
				break;

			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 6.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}
	
	public static void insertarLibro(Set<Producto> productos) {
		String nombre = Teclado.leerCadena("Nombre: ");
		String categoria = Teclado.leerCadena("Categoria: ");
		int stock = Teclado.leerEntero("Stock: ");
		
		String escritor = Teclado.leerCadena("Escritor: ");
		String editorial = Teclado.leerCadena("Editorial: ");

		Libro libro = new Libro(nombre, categoria, stock, escritor, editorial);

		if (productos.add(libro)) {
			System.out.println("Se ha insertado el libro en el conjunto.");
		} else {
			System.out.println("Ya existe otro libro con ese código en el conjunto.");
		}
	}
	
	public static void insertarPelicula(Set<Producto> productos) {
		String nombre = Teclado.leerCadena("Nombre: ");
		String categoria = Teclado.leerCadena("Categoria: ");
		int stock = Teclado.leerEntero("Stock: ");
		
		String director = Teclado.leerCadena("Director: ");
		int duracion = Teclado.leerEntero("Duración: ");

		Pelicula pelicula = new Pelicula(nombre, categoria, stock, director, duracion);

		if (productos.add(pelicula)) {
			System.out.println("Se ha insertado la película en el conjunto.");
		} else {
			System.out.println("Ya existe otra película con ese código en el conjunto.");
		}
	}
	
	public static void insertarVideojuego(Set<Producto> productos) {
		String nombre = Teclado.leerCadena("Nombre: ");
		String categoria = Teclado.leerCadena("Categoria: ");
		int stock = Teclado.leerEntero("Stock: ");
		
		String plataforma = Teclado.leerCadena("Plataforma: ");
		String desarrollador = Teclado.leerCadena("Desarrollador: ");

		Videojuego videojuego = new Videojuego(nombre, categoria, stock, plataforma, desarrollador);

		if (productos.add(videojuego)) {
			System.out.println("Se ha insertado el videojuego en el conjunto.");
		} else {
			System.out.println("Ya existe otro videojuego con ese código en el conjunto.");
		}
	}
	
	public static void consultarLibros(Set<Producto> productos) {
		for (Producto producto : productos) {
			if (producto instanceof Libro) {
				System.out.println(producto.toString());
			}
		}
	}
	
	public static void consultarPeliculas(Set<Producto> productos) {
		List<Pelicula> aux = new ArrayList<Pelicula>();
		
		for (Producto producto : productos) {
			if (producto instanceof Pelicula) {
				aux.add((Pelicula) producto);
			}
		}
		
		Collections.sort(aux, new ComparadorPeliculaDirector());
		
		for (Pelicula pelicula : aux) {
			System.out.println(pelicula.toString());
		}
	}
	
	public static void consultarVideojuegos(Set<Producto> productos) {
		String plataforma = Teclado.leerCadena("Plataforma: ");
		
		for (Producto producto : productos) {
			if (producto instanceof Videojuego && ((Videojuego) producto).getPlataforma().equals(plataforma)) {
				System.out.println(producto.toString());
			}
		}
		
	}
	
	public static void datosPrueba(Set<Producto> productos) {
		productos.add(new Libro("libro1", "a", 1, "e1", "ed1"));
		productos.add(new Libro("libro2", "a", 1, "e1", "ed1"));
		productos.add(new Libro("libro3", "a", 1, "e1", "ed1"));
		
		productos.add(new Pelicula("peli1", "a", 1, "b", 1));
		productos.add(new Pelicula("peli2", "a", 1, "c", 1));
		productos.add(new Pelicula("peli3", "a", 1, "a", 1));
		
		productos.add(new Videojuego("juego1", "a", 1, "p2", "d2"));
		productos.add(new Videojuego("juego2", "a", 1, "p3", "d3"));
		productos.add(new Videojuego("juego3", "a", 1, "p1", "d1"));
		productos.add(new Videojuego("juego4", "a", 1, "p2", "d4"));
		productos.add(new Videojuego("juego5", "a", 1, "p1", "d2"));
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(1) Insertar un libro en la colección.\r\n"
				+ "(2) Insertar una película en la colección.\r\n"
				+ "(3) Insertar un videojuego en la colección.\r\n"
				+ "(4) Consultar todos los productos de la colección, en orden de inserción.\r\n"
				+ "(5) Consultar todos los productos de la colección, por orden de nombre ascendente.\r\n"
				+ "(6) Consultar todos los productos de la colección, por orden de precio descendente.\r\n"
				+ "(7) Consultar los productos de la colección pertenecientes a una categoría.\r\n"
				+ "(8) Eliminar un producto, por código, de la colección.\r\n"
				+ "(9) Eliminar los productos de la colección que tienen cero unidades en stock.\r\n"
				+ "\r\n"
				+ "(10) Consultar los libros de la colección.\r\n"
				+ "(11) Consultar las películas de la colección, por orden de director ascendente.\r\n"
				+ "(12) Consultar los videojuegos de la colección relativos a una plataforma.\r\n"
				+ "(13) Insertar una película con datos aleatorios en la colección.\r\n"
				+ "(14) Insertar de forma aleatoria una cantidad de productos con datos aletorios en la colección.\r\n"
				+ "(15) Actualizar los libros de la colección relativos a un escritor con una nueva editorial.\r\n"
				+ "(16) Eliminar los videojuegos de la colección correspondientes a una plataforma.\r\n"
				+ "\r\n"
				+ "(17) Consultar los productos de la colección más caros.\r\n"
				+ "(18) Consultar el número de productos de cada categoría de la colección.\r\n"
				+ "(19) Consultar los productos que tienen más unidades en stock de cada categoría de la colección.");
	}

}
