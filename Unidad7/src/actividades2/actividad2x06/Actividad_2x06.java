package actividades2.actividad2x06;

import java.util.Set;
import java.util.TreeSet;

import entrada.Teclado;

public class Actividad_2x06 {

	public static void main(String[] args) {

		Set<Pelicula> peliculas = new TreeSet<Pelicula>();
		int opcion = 0;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarPelicula(peliculas);
				break;
			case 2:
				consultarPeliculasOrdenInsercion(peliculas);
				break;
			case 3:
				consultarPeliculasOrdenAnioAsc(peliculas);
				break;
			case 4:
				consultarPeliculasDirectorOrdenPuntDesc(peliculas);
				break;
			case 5:
				eliminarPeliculas(peliculas);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 6.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}

	public static void insertarPelicula(Set<Pelicula> peliculas) {
		String codigo = Teclado.leerCadena("Código: ");
		String titulo = Teclado.leerCadena("Título: ");
		String director = Teclado.leerCadena("Director: ");
		int anyo = Teclado.leerEntero("Año: ");
		int duracion = Teclado.leerEntero("Duración: ");
		Double puntuacion = Teclado.leerReal("Puntuación: ");

		Pelicula pelicula = new Pelicula(codigo, titulo, director, anyo, duracion, puntuacion);

		//insertar
	}

	public static void consultarPeliculasOrdenInsercion(Set<Pelicula> peliculas) {

	}

	public static void consultarPeliculasOrdenAnioAsc(Set<Pelicula> peliculas) {

	}

	public static void consultarPeliculasDirectorOrdenPuntDesc(Set<Pelicula> peliculas) {

	}

	public static void eliminarPeliculas(Set<Pelicula> peliculas) {

	}

	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar una película en el conjunto.");
		System.out.println("(2) Consultar todas las películas del conjunto, en orden de inserción.");
		System.out.println("(3) Consultar todas las películas del conjunto, en orden por año de estreno ascendente.");
		System.out.println(
				"(4) Consultar varias películas, por director, del conjunto, en orden por puntuación descendente.");
		System.out.println("(5) Eliminar varias películas, entre dos duraciones, del conjunto.");
	}

}
