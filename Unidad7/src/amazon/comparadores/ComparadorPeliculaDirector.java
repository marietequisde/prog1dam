package amazon.comparadores;

import java.util.Comparator;

import amazon.Pelicula;

public class ComparadorPeliculaDirector implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		return o1.getDirector().compareTo(o2.getDirector());
	}
}
