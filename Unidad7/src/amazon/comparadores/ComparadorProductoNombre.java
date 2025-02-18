package amazon.comparadores;

import java.util.Comparator;
import amazon.Producto;

public class ComparadorProductoNombre implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
}
