package principal;

import java.util.Map;

import org.neodatis.odb.ODBRuntimeException;

import acceso.AccesoDepartamento;
import entrada.Teclado;
import modelo.Departamento;

public class Actividad_1x01 {

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

			} catch (ODBRuntimeException e) {
				System.out.println("Error de NeoDatis: " + e.getMessage());
				e.printStackTrace();
			}
			System.out.println();
		} while (opcion != 0);
	}

	public static void insertarDepartamento() {
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");

		Departamento departamento = new Departamento(nombre, ubicacion);

		AccesoDepartamento.insertar(departamento);
		System.out.println("Se ha insertado un departamento en la base de datos.");

	}

	public static void consultarDepartamentos() {
		Map<String, Departamento> departamentos = AccesoDepartamento.consultarTodos();
		escribirMapaDepartamentos(departamentos);
	}

	public static void consultarDepartamento() {
		int codigo = Teclado.leerEntero("Código: ");
		Departamento departamento = AccesoDepartamento.consultar(codigo);

		if (departamento != null) {
			System.out.println(departamento.toString());
		} else {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
	}

	public static void actualizarDepartamento() {
		int codigo = Teclado.leerEntero("Código: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");

		if (AccesoDepartamento.actualizar(codigo, nombre, ubicacion) != null) {
			System.out.println("Se ha actualizado un departamento de la base de datos.");
		} else {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
	}

	public static void eliminarDepartamento()  {
		int codigo = Teclado.leerEntero("Código: ");

		if (AccesoDepartamento.eliminar(codigo)) {
			System.out.println("Se ha eliminado un departamento de la base de datos.");
		} else {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
	}
	
	private static void escribirMapaDepartamentos(Map<String, Departamento> departamentos) {
		if (!departamentos.isEmpty()) {
			for (Map.Entry<String, Departamento> entry : departamentos.entrySet()) {
				System.out.printf("OID = %s -->\n%s\n", entry.getKey(), entry.getValue());
			}
			System.out.printf("Se han consultado %d departamentos de la base de datos.\n", departamentos.size());
		} else {
			System.out.println("La base de datos no tiene ningún departamento.");
		}
	}

	private static void escribirMenuOpciones() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Insertar un departamento en la base de datos.");
		System.out.println("2) Consultar todos los departamentos de la base de datos.");
		System.out.println("3) Consultar un departamento, por código, de la base de datos.");
		System.out.println("4) Actualizar un departamento, por código, de la base de datos.");
		System.out.println("5) Eliminar un departamento, por código, de la base de datos.\r\n");
	}

}
