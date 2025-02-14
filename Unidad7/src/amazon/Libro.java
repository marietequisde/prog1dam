package amazon;

public class Libro extends Producto {

	private final static double PRECIO_BASE = 30;
	private final static double PRECIO_MINIMO = 10;

	private String escritor;
	private String editorial;

	public Libro(String nombre, String categoria, int stock, String escritor, String editorial) {
		super(nombre, categoria, stock);
		this.escritor = escritor;
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [" + super.toString() + ", escritor=" + escritor + ", editorial=" + editorial + "]";
	}
	
	@Override
	public double calcularPrecio() {
		return Math.max(PRECIO_BASE - super.getStock()*0.1, PRECIO_MINIMO);
	}

}
