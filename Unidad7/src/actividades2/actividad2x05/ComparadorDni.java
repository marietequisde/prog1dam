package actividades2.actividad2x05;

import java.util.Comparator;

public class ComparadorDni implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getDni().compareTo(o2.getDni());
	}

}
