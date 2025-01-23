package catalogo_videos;

public class Pelicula extends Video {

	private int anyoEstreno;
	private String director;

	public Pelicula(String titulo, double puntuacion, int anyoEstreno, String director) {
		super(titulo, puntuacion);
		this.anyoEstreno = anyoEstreno;
		this.director = director;
	}

	public int getAnyoEstreno() {
		return anyoEstreno;
	}

	public String getDirector() {
		return director;
	}
	
	@Override
	public String toString() {
		String puntuacionString = String.format("%.1f", super.getPuntuacion()); 
		return "Pelicula[codigo=" + super.getCodigo() + 
									", titulo=" + super.getTitulo() + 
									", puntuacion=" + puntuacionString +
									", anyoEstreno=" + anyoEstreno +
									", director=" + director + "]";
	}

}
