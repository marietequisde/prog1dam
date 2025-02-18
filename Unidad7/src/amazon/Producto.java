package amazon;

import java.util.Objects;

public abstract class Producto {

	private static int numProductos = 0;

	private int codigo;
	private String nombre;
	private String categoria;
	private int stock;

	public Producto(String nombre, String categoria, int stock) {
		this.codigo = numProductos++;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
	}

	public abstract double calcularPrecio();

	@Override
	public int hashCode() {
		return Objects.hash(categoria, codigo, nombre, getStock());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", stock=" + getStock()
				+ ", precio=" + calcularPrecio();
	}

	public int getCodigo() {
		return codigo;
	}

	public int getStock() {
		return stock;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}

}
