package actividades1.actividad1x03;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		return o2.getPrecio().compareTo(o1.getPrecio());
	}

}
                      