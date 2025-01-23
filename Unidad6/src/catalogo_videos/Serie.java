package catalogo_videos;

public class Serie extends Video {

	private int anyoInicio;
	private int anyoFin;
	private int numTemporadas;
	private int numCapitulos;

	public Serie(String titulo, double puntuacion, int anyoInicio, int anyoFin, int numTemporadas, int numCapitulos) {
		super(titulo, puntuacion);
		this.anyoInicio = anyoInicio;
		this.anyoFin = anyoFin;
		this.numTemporadas = numTemporadas;
		this.numCapitulos = numCapitulos;
	}

	public int getAnyoInicio() {
		return anyoInicio;
	}

	public int getAnyoFin() {
		return anyoFin;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public int getNumCapitulos() {
		return numCapitulos;
	}
	
	@Override
	public String toString() {
		String puntuacionString = String.format("%.1f", super.getPuntuacion()); 
		return "Serie[codigo=" + super.getCodigo() + 
									", titulo=" + super.getTitulo() + 
									", puntuacion=" + puntuacionString +
									", anyoInicio=" + anyoInicio +
									", anyoFin=" + anyoFin +
									", numTemporadas=" + numTemporadas +
									", numCapitulos" + numCapitulos + "]";
	}

}
