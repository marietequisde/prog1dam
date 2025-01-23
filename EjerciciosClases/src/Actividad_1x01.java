import entrada.Teclado;

public class Actividad_1x01 {

	public static void main(String[] args) {
		String nombre, desarrollador;
		int anyo, maxJugadores;
		
		System.out.println("VIDEOJUEGO 1");
		
		nombre = Teclado.leerCadena("¿Nombre? ");
		desarrollador = Teclado.leerCadena("¿Desarrollador? ");
		anyo = Teclado.leerEntero("¿Año? ");
		maxJugadores = Teclado.leerEntero("¿Número Máximo de Jugadores? ");
		
		Videojuego miVideojuego = new Videojuego(nombre, desarrollador, anyo, maxJugadores);
		System.out.println(miVideojuego);
		
		System.out.println("\nVIDEOJUEGO 2");
		
		nombre = Teclado.leerCadena("¿Nombre? ");
		desarrollador = Teclado.leerCadena("¿Desarrollador? ");
		anyo = Teclado.leerEntero("¿Año? ");
		
		miVideojuego = new Videojuego(nombre, desarrollador, anyo);
		System.out.println(miVideojuego);
		
		System.out.println("\nVIDEOJUEGO 1");
		
		nombre = Teclado.leerCadena("¿Nombre? ");
		desarrollador = Teclado.leerCadena("¿Desarrollador? ");
		
		miVideojuego = new Videojuego(nombre, desarrollador);
		System.out.println(miVideojuego);
	}
}
