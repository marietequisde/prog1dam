package actividades.actividad1x03;

import java.util.Objects;

public class Libro {

	private String isbn;
	private String titulo;
	private String escritor;
	private int anyoPublicacion;
	private int stock;
	private double precio;

	public Libro(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public String getEscritor() {
		return escritor;
	}
	
	public Double getPrecio() {
		return precio;
	}

	public Libro(String isbn, String titulo, String escritor, int anyoPublicacion, int stock, double precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.escritor = escritor;
		this.anyoPublicacion = anyoPublicacion;
		this.stock = stock;
		this.precio = precio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", escritor=" + escritor + ", anyoPublicacion="
				+ anyoPublicacion + ", stock=" + stock + ", precio=" + String.format("%.2f", precio) + "]";
	}

}
