import entrada.Teclado;

/**
 * Añadir contacto
 * Consultar agenda completa
 * Eliminar contacto por posicion
 */
public class Principal {

	public static void main(String[] args) {
		Agenda agenda = new Agenda("mario", 15);
		String nombre, telefono, email;
		int posicion;
		int opcion = 0;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				nombre = Teclado.leerCadena("¿Nombre? ");
				telefono = Teclado.leerCadena("¿Telefono? ");
				email = Teclado.leerCadena("¿Email? ");
				if (agenda.insertarContacto(new Contacto(nombre, telefono, email))) {
					System.out.println("Se ha insertado un contacto en la agenda.");
				} else {
					System.out.println("No se ha podido insertar.");
				}
				break;
			case 2:
				System.out.println(agenda.toString());
				if (agenda.estaVacia()) {
					System.out.println("No hay contactos en la agenda.");
				}
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}
	
	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar contacto.");
		System.out.println("(2) Consultar toda la información de la agenda.");
		
		System.out.println("(3) Eliminar contacto por posición.");
		System.out.println("(4) Consultar contacto por posición.");
		System.out.println("(5) Consultar contacto por nombre.");
	}

}
