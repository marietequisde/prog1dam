package actividades2.actividad2x01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class Actividad_2x01 {

	public static void main(String[] args) {
		int opcion = 0;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();
			try {
				switch (opcion) {
				case 0:
					break;
				case 1:
					insertarDepartamento();
					break;
				case 2:
					consultarDepartamentos();
					break;
				case 3:
					consultarDepartamento();
					break;
				case 4:
					actualizarDepartamento();
					break;
				case 5:
					eliminarDepartamento();
					break;
				default:
					System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
					break;
				}

			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el fichero: " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error al leer del fichero: " + e.getMessage());
				e.printStackTrace();
			}
			System.out.println();
		} while (opcion != 0);
	}

	public static void insertarDepartamento() throws FileNotFoundException, IOException {
		int codigo = Teclado.leerEntero("Código: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");

		Departamento departamento = new Departamento(codigo, nombre, ubicacion);

		if (AccesoDepartamento.insertar(departamento)) {
			System.out.println("Se ha insertado un departamento en el fichero de texto.");
		} else {
			System.out.println("Ya existe otro departamento con ese código en el fichero de texto.");
		}
	}

	public static void consultarDepartamentos() throws FileNotFoundException, IOException {
		List<Departamento> departamentos = AccesoDepartamento.leerTodos();
		if (!departamentos.isEmpty()) {
			for (Departamento departamento : departamentos) {
				System.out.println(departamento.toString());
			}
			System.out.printf("Se han consultado %d departamentos del fichero de texto.", departamentos.size());
		} else {
			System.out.println("El fichero de texto no tiene ningún departamento.");
		}

	}

	public static void consultarDepartamento() throws FileNotFoundException, IOException {
		int codigo = Teclado.leerEntero("Código: ");
		Departamento departamento = AccesoDepartamento.leer(codigo);

		if (departamento != null) {
			System.out.println(departamento.toString());
		} else {
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
		}
	}

	public static void actualizarDepartamento() throws FileNotFoundException, IOException {
		int codigo = Teclado.leerEntero("Código: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");

		if (AccesoDepartamento.actualizar(codigo, nombre, ubicacion)) {
			System.out.println("Se ha actualizado un departamento del fichero de texto.");
		} else {
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
		}
	}

	public static void eliminarDepartamento() throws FileNotFoundException, IOException {
		int codigo = Teclado.leerEntero("Código: ");

		if (AccesoDepartamento.eliminar(codigo)) {
			System.out.println("Se ha eliminado un departamento del fichero de texto.");
		} else {
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
		}
	}

	private static void escribirMenuOpciones() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Insertar un departamento en el fichero de texto.");
		System.out.println("2) Consultar todos los departamentos del fichero de texto.");
		System.out.println("3) Consultar un departamento, por código, del fichero de texto.");
		System.out.println("4) Actualizar un departamento, por código, del fichero de texto.");
		System.out.println("5) Eliminar un departamento, por código, del fichero de texto.\r\n");
	}

}
