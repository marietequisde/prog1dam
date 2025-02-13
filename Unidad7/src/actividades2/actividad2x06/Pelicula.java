package actividades2.actividad2x06;

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

	@Override
	public String toString() {
		return String.format("Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", director=" + director + ", anyoEstreno="
				+ anyoEstreno + ", duracion=" + duracion + ", puntuacion=%.1f]", puntuacion);
	}
	
	
	
}
