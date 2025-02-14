package actividades2.actividad2x05.comparadores;

import java.util.Comparator;

import actividades2.actividad2x05.Cliente;

public class ComparadorFecha implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
	}
	
}