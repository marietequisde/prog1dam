package amazon.comparadores;

import java.util.Comparator;
import amazon.Producto;

public class ComparadorProductoPrecio implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		return Double.compare(o2.calcularPrecio(), o1.calcularPrecio());
	}
}
