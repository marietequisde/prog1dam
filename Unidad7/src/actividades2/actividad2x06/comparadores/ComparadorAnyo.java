package actividades2.actividad2x06.comparadores;

import java.util.Comparator;

import actividades2.actividad2x06.Pelicula;

public class ComparadorAnyo implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		return Integer.compare(o1.getAnyoEstreno(), o2.getAnyoEstreno());
	}

}
