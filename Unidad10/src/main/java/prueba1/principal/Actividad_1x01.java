package prueba1.principal;

import java.sql.SQLException;
import java.util.List;
import lib.Teclado;
import java.util.Map;

import prueba1.acceso.AccesoDepartamento;

import prueba1.modelo.Departamento;

public class Actividad_1x01 {

	public static void main(String[] args) {
		int opcion = 0;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opci?n: ");
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
					System.out.println("La opci?n de men? debe estar comprendida entre 0 y 5.");
					break;
				}

			} catch (Exception e) {
				System.out.println("Error de BBDD: " + e.getMessage());
				e.printStackTrace();
			}
			System.out.println();
		} while (opcion != 0);
	}

	public static void insertarDepartamento() throws ClassNotFoundException, SQLException {
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicaci?n: ");

		Departamento departamento = new Departamento(nombre, ubicacion);

		AccesoDepartamento.insertar(departamento);
		System.out.println("Se ha insertado un departamento en la base de datos.");

	}

	public static void consultarDepartamentos() throws ClassNotFoundException, SQLException {
		List<Departamento> departamentos = AccesoDepartamento.consultarTodos();
		escribirListaDepartamentos(departamentos);
	}

	public static void consultarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("C?digo: ");
		Departamento departamento = AccesoDepartamento.consultar(codigo);

		if (departamento != null) {
			System.out.println(departamento.toString());
		} else {
			System.out.println("No existe ning?n departamento con ese c?digo en la base de datos.");
		}
	}

	public static void actualizarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("C?digo: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicaci?n: ");

		if (AccesoDepartamento.actualizar(codigo, nombre, ubicacion)) {
			System.out.println("Se ha actualizado un departamento de la base de datos.");
		} else {
			System.out.println("No existe ning?n departamento con ese c?digo en la base de datos.");
		}
	}

	public static void eliminarDepartamento() throws ClassNotFoundException, SQLException  {
		int codigo = Teclado.leerEntero("C?digo: ");

		if (AccesoDepartamento.eliminar(codigo)) {
			System.out.println("Se ha eliminado un departamento de la base de datos.");
		} else {
			System.out.println("No existe ning?n departamento con ese c?digo en la base de datos.");
		}
	}
	
	private static void escribirListaDepartamentos(List<Departamento> departamentos) {
		if (!departamentos.isEmpty()) {
                    for (Departamento departamento : departamentos) {
                        System.out.println(departamento.toString());
                    }
			System.out.printf("Se han consultado %d departamentos de la base de datos.\n", departamentos.size());
		} else {
			System.out.println("La base de datos no tiene ning?n departamento.");
		}
	}

	private static void escribirMenuOpciones() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Insertar un departamento en la base de datos.");
		System.out.println("2) Consultar todos los departamentos de la base de datos.");
		System.out.println("3) Consultar un departamento, por c?digo, de la base de datos.");
		System.out.println("4) Actualizar un departamento, por c?digo, de la base de datos.");
		System.out.println("5) Eliminar un departamento, por c?digo, de la base de datos.\r\n");
	}

}
