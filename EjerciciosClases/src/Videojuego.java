
public class Videojuego {
	
	private String nombre;
	private String desarrollador;
	private int anyo;
	private int maxJugadores;
	
	public Videojuego(String nombre, String desarrollador, int anyo, int maxJugadores) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.anyo = anyo;
		this.maxJugadores = maxJugadores;
	}

	public Videojuego(String nombre, String desarrollador, int anyo) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.anyo = anyo;
		this.maxJugadores = 1;
	}

	public Videojuego(String nombre, String desarrollador) {
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.anyo = 2023;
		this.maxJugadores = 1;
	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", desarrollador=" + desarrollador + ", anyo=" + anyo
				+ ", maxJugadores=" + maxJugadores + "]";
	}
	
}
