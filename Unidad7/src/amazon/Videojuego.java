package amazon;

public class Videojuego extends Producto {

	private final static double PRECIO_BASE = 40;
	private final static double PRECIO_MINIMO = 20;

	private String plataforma;
	private String desarrollador;
	
	public Videojuego(String nombre, String categoria, int stock, String plataforma, String desarrollador) {
		super(nombre, categoria, stock);
		this.plataforma = plataforma;
		this.desarrollador = desarrollador;
	}

	@Override
	public String toString() {
		return "Libro [" + super.toString() + ", plataforma=" + plataforma + ", desarrollador=" + desarrollador + "]";
	}
	
	@Override
	public double calcularPrecio() {
		if (super.getStock() <= 100) {
			return PRECIO_MINIMO;
		}
		return Math.max(PRECIO_BASE - (super.getStock()-100)*0.5, PRECIO_MINIMO);
	}

}
