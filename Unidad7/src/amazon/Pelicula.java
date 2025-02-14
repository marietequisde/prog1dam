package amazon;

public class Pelicula extends Producto {

	private final static double PRECIO_BASE = 20;
	private final static double PRECIO_MINIMO = 15;

	private String director;
	private int duracion;

	public Pelicula(String nombre, String categoria, int stock, String director, int duracion) {
		super(nombre, categoria, stock);
		this.director = director;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Pelicula [" + super.toString() + ", director=" + director + ", duracion=" + duracion + "]";
	}

	@Override
	public double calcularPrecio() {
		return Math.max(PRECIO_BASE - super.getStock()/10, PRECIO_MINIMO);
	}

}
