package catalogo_videos;

public abstract class Video implements Comparable<Video>{

	public static int contador = 0;

	private int codigo;
	private String titulo;
	private double puntuacion;
	
	public Video(String titulo, double puntuacion) {
		super();
		this.codigo = contador++;
		this.titulo = titulo;
		this.puntuacion = puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public int compareTo(Video o) {
		if (this instanceof Pelicula && o instanceof Serie) {
			return -1;
		}
		if (this instanceof Serie && o instanceof Pelicula) {
			return 1;
		}
		return this.getTitulo().compareToIgnoreCase(o.getTitulo());
	}

}
