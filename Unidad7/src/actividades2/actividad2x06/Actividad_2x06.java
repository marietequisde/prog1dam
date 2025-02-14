package actividades2.actividad2x06;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import actividades2.actividad2x06.comparadores.ComparadorAnyo;
import actividades2.actividad2x06.comparadores.ComparadorPuntuacionDesc;
import entrada.Teclado;

public class Actividad_2x06 {

	public static void main(String[] args) {

		Set<Pelicula> peliculas = new LinkedHashSet<Pelicula>();
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

		if (peliculas.add(pelicula)) {
			System.out.println("Se ha insertado la película en el conjunto.");
		} else {
			System.out.println("Ya existe otra película con ese código en el conjunto.");
		}
	}

	public static void consultarPeliculasOrdenInsercion(Set<Pelicula> peliculas) {
		Iterator<Pelicula> it = peliculas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.printf("Se han consultado %d películas del conjunto.", peliculas.size());
	}

	public static void consultarPeliculasOrdenAnioAsc(Collection<Pelicula> peliculas) {
		if (!peliculas.isEmpty()) {
			List<Pelicula> aux = new LinkedList<Pelicula>();
			aux.addAll(peliculas);
			Collections.sort(aux, new ComparadorAnyo());

			for (Pelicula pelicula : aux) {
				System.out.println(pelicula.toString());
			}
			
			System.out.printf("Se han consultado %d películas del conjunto.", aux.size());

		} else {
			System.out.println("El conjunto está vacío.");
		}
	}

	public static void consultarPeliculasDirectorOrdenPuntDesc(Set<Pelicula> peliculas) {
		if (!peliculas.isEmpty()) {
			String director = Teclado.leerCadena("Director: ");
			List<Pelicula> aux = new LinkedList<Pelicula>();
			for (Pelicula pelicula : peliculas) {
				if (pelicula.getDirector().equals(director)) {
					aux.add(pelicula);
				}
			}
			Collections.sort(aux, new ComparadorPuntuacionDesc());

			for (Pelicula pelicula : aux) {
				System.out.println(pelicula.toString());
			}
			
			System.out.printf("Se han consultado %d películas del conjunto.", aux.size());

		} else {
			System.out.println("El conjunto está vacío.");
		}
	}

	public static void eliminarPeliculas(Set<Pelicula> peliculas) {
		int duracionMin = Teclado.leerEntero("Duración mínima: ");
		int duracionMax = Teclado.leerEntero("Duración máxima: ");
		int eliminadas = 0;

		Iterator<Pelicula> it = peliculas.iterator();
		while (it.hasNext()) {
			Pelicula pelicula = it.next();
			if (entreDuracion(pelicula, duracionMin, duracionMax)) {
				it.remove();
				eliminadas++;
			}
		}
		
		if (eliminadas > 0) {
			System.out.printf("Se han eliminado %d películas del conjunto.", eliminadas);
		} else {
			System.out.println("No existe ninguna película entre esas duraciones mínima y máxima en el conjunto.");
		}
	}
	
	private static boolean entreDuracion(Pelicula pelicula, int minDuracion, int maxDuracion) {
		return pelicula.getDuracion() >= minDuracion&& 
				pelicula.getDuracion() <= maxDuracion;
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
