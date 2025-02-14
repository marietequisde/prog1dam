package actividades2.actividad2x06;

import java.util.Objects;

public class Pelicula {

	private String codigo;
	private String titulo;
	private String director;
	private int anyoEstreno;
	private int duracion;
	private Double puntuacion;

	public Pelicula(String codigo, String titulo, String director, int anyoEstreno, int duracion, Double puntuacion) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.anyoEstreno = anyoEstreno;
		this.duracion = duracion;
		this.puntuacion = puntuacion;
	}

	public String getDirector() {
		return director;
	}

	public int getAnyoEstreno() {
		return anyoEstreno;
	}

	public int getDuracion() {
		return duracion;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	@Override
	public String toString() {
		return String.format("Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", director=" + director
				+ ", anyoEstreno=" + anyoEstreno + ", duracion=" + duracion + ", puntuacion=%.1f]", puntuacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(anyoEstreno, codigo, director, duracion, puntuacion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
