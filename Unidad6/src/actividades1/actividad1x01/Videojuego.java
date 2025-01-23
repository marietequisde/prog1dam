package actividades1.actividad1x01;

public class Videojuego {
	
	private static int indice = 0;
	
	private int codigo;
	private String titulo;
	private double precio;
	private int stock;
	
	public Videojuego(String titulo, double precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = Videojuego.indice++;
		this.stock = 10;
	}
	
	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		String precioString = String.format("%.2f", precio); 
		return "Videojuego [codigo=" + codigo + 
									", titulo=" + titulo + 
									", precio=" + precioString + 
									", stock=" + stock + "]";
	}
	
}
