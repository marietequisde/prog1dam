package amazon.comparadores.comparadores_pelicula;

import java.util.Comparator;

import amazon.Pelicula;

public class ComparadorPeliculaDirector implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		return o1.getDirector().compareToIgnoreCase(o2.getDirector());
	}
}
