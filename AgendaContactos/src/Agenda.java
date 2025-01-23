import java.util.Arrays;

public class Agenda {

	private String propietario;
	private Contacto[] contactos;
	
	private int indice;
	
	public Agenda(String propietario, int capacidad) {
		this.propietario = propietario;
		this.contactos = new Contacto[capacidad];
		
		this.indice = 0;
	}
	
	public boolean insertarContacto(Contacto contacto) {
		if (indice < contactos.length) {
			contactos[indice++] = contacto;
			return true;
		}
		return false;
	}
	
	public boolean estaVacia() {
		return Arrays.stream(contactos)
				.filter(c -> c != null)
				.findFirst()
				.isEmpty();
	}
	
	public int contarContactos() {
		return (int) Arrays.stream(contactos)
					.filter(c -> c != null)
					.count();
	}

	@Override
	public String toString() {
		String cadena = "Propietario: " + this.propietario + "\n";
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null) {
				cadena += contactos[i].toString() + "\n";
			}
		}
		if (estaVacia()) {
			cadena += "No hay contactos en la agenda.";
		} else {
			cadena += "Se han encontrado " + contarContactos() + " contactos.";
		}
		return cadena;
	}
	
	
}
