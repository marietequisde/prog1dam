package catalogo_videos;

import entrada.Teclado;

public class Principal {

	public static void main(String[] args) {
		Catalogo catalogo = new Catalogo(6);
		int opcion = 0;
		
		Pelicula pelicula1 = new Pelicula("a", 2.1, 3, "a");
		Pelicula pelicula2 = new Pelicula("b", 2.1, 3, "b");
		Serie serie1 = new Serie("a", 3, 3, 3, 3, 3);
		Serie serie2 = new Serie("a", 3, 3, 3, 3, 3);
		
		catalogo.insertar(pelicula1);
		catalogo.insertar(serie1);
		catalogo.insertar(serie2);
		catalogo.insertar(pelicula2);

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarPelicula(catalogo);
				break;
			case 2:
				insertarSerie(catalogo);
				break;
			case 3:
				consultarTodos(catalogo);
				break;
			case 4:
				consultarPorPuntuacion(catalogo);
				break;
			case 5:
				consultarPeliculasPorDirector(catalogo);
				break;
			case 6:
				consultarSeriesPorAnyo(catalogo);
				break;
			case 7:
				actualizarPuntuacion(catalogo);
				break;
			case 8:
				eliminarVideo(catalogo);
				break;
			case 9:
				reorganizar(catalogo);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 9.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar una película en el catálogo.");
		System.out.println("(2) Insertar una serie en el catálogo.");
		System.out.println("(3) Consultar todos los vídeos del catálogo.");
		System.out.println("(4) Consultar los vídeos del catálogo con una puntuación comprendida entre dos límites.");
		System.out.println("(5) Consultar las películas del catálogo dirigidas por un director.");
		System.out.println("(6) Consultar las series del catálogo emitidas en un año de emisión.");
		System.out.println("(7) Actualizar la puntuación de un vídeo, por código, del catálogo.");
		System.out.println("(8) Eliminar un vídeo, por código, del catálogo.");
		System.out.println("(9) Reorganizar el catálogo de forma que incluya primero las películas y luego las series.");
	}
	
	public static void reorganizar(Catalogo catalogo) {
		catalogo.reorganizarCatalogo();
	}
	
	public static void eliminarVideo(Catalogo catalogo) {
		int codigo = Teclado.leerEntero("Código: ");
		
		if (catalogo.eliminar(codigo)) {
			System.out.println("Video eliminado correctamente");
		} else {
			System.out.println("Video no encontrado");
		}
	}
	
	public static void actualizarPuntuacion(Catalogo catalogo) {
		int codigo = Teclado.leerEntero("Código: ");
		double puntuacion = Teclado.leerReal("Nueva puntuación: ");
		
		if (catalogo.actualizarPuntuacion(codigo, puntuacion)) {
			System.out.println("Puntuación actualizada correctamente");
		} else {
			System.out.println("Video no encontrado");
		}
	}
	
	public static void consultarSeriesPorAnyo(Catalogo catalogo) {
		int anyo = Teclado.leerEntero("Año: ");
		System.out.printf(catalogo.consultar(anyo));
	}
	
	public static void consultarPeliculasPorDirector(Catalogo catalogo) {
		String director = Teclado.leerCadena("Director: ");
		System.out.printf(catalogo.consultar(director));
	}
	
	public static void consultarPorPuntuacion(Catalogo catalogo) {
		double minPuntuacion = Teclado.leerReal("Puntuación mínima: ");
		double maxPuntuacion = Teclado.leerReal("Puntuación máxima: ");
		
		System.out.printf(catalogo.consultar(minPuntuacion, maxPuntuacion));
	}
	
	public static void insertarSerie(Catalogo catalogo) {
		String titulo = Teclado.leerCadena("Título: ");
		double puntuacion = Teclado.leerReal("Precio: ");
		int anyoInicio = Teclado.leerEntero("Año de inicio: ");
		int anyoFin = Teclado.leerEntero("Año de finalización: ");
		int numTemporadas = Teclado.leerEntero("Número de temporadas: ");
		int numCapitulos = Teclado.leerEntero("Número de capítulos: ");
		
		Serie serie = new Serie(titulo, puntuacion, anyoInicio, anyoFin, numTemporadas, numCapitulos);
		
		if (catalogo.insertar(serie)) {
			System.out.println("Se ha insertado la serie en el catálogo con éxito.");
		} else {
			System.out.println("Error al insertar: catálogo lleno.");
		}
	}
	
	private static void consultarTodos(Catalogo catalogo) {
		System.out.printf(catalogo.toString());
	}
	
	public static void insertarPelicula(Catalogo catalogo) {
		String titulo = Teclado.leerCadena("Título: ");
		double puntuacion = Teclado.leerReal("Precio: ");
		int anyoEstreno = Teclado.leerEntero("Año de estreno: ");
		String director = Teclado.leerCadena("Director: ");
		
		Pelicula pelicula = new Pelicula(titulo, puntuacion, anyoEstreno, director);
		
		if (catalogo.insertar(pelicula)) {
			System.out.println("Se ha insertado la película en el catálogo con éxito.");
		} else {
			System.out.println("Error al insertar: catálogo lleno.");
		}
	}

}
