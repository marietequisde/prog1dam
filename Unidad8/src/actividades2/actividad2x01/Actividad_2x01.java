package actividades2.actividad2x01;

import actividades2.actividad2x01.excepciones.ExcepcionClientela;
import actividades2.actividad2x01.excepciones.ExcepcionUsuario;
import entrada.Teclado;

public class Actividad_2x01 {

	public static void main(String[] args) {

		Clientela clientela = new Clientela(100);
		int opcion;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("Opcion: ");

			System.out.println();
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarUsuario(clientela);
				break;
			case 2:
				consultarTodos(clientela);
				break;
			case 3:
				eliminarUsuario(clientela);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
				break;
			}
			
			System.out.println();

		} while (opcion != 0);

	}

	public static void insertarUsuario(Clientela clientela) {
		String nombre = Teclado.leerCadena("Nombre: ");
		String pass = Teclado.leerCadena("Contraseña: ");
		int numPuntos = Teclado.leerEntero("Puntos: ");

		try {
			Usuario usuario = new Usuario(nombre, pass, numPuntos);
			clientela.insertarUsuario(usuario);
			System.out.println("Se ha insertado el usuario en la clientela con éxito.");

		} catch (ExcepcionUsuario e) {
			System.out.println("Se ha producido un error de usuario.");
			System.out.println(e.toString());

		} catch (ExcepcionClientela e) {
			System.out.println("Se ha producido un error de clientela.");
			System.out.println(e.toString());
		}

	}
	
	public static void consultarTodos(Clientela clientela) {
		System.out.println(clientela.toString());
	}
	
	public static void eliminarUsuario(Clientela clientela) {
		int posicion = Teclado.leerEntero("Posicion: ");

		try {
			clientela.eliminarUsuario(posicion);
			System.out.println("Se ha eliminado el usuario de la clientela con éxito.");

		} catch (ExcepcionClientela e) {
			System.out.println("Se ha producido un error de clientela.");
			System.out.println(e.toString());
		}

	}

	public static void escribirMenu() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Insertar un usuario en la clientela.");
		System.out.println("2) Consultar todos los usuarios de la clientela.");
		System.out.println("3) Eliminar un usuario, por posición, de la clientela.");
	}

}
