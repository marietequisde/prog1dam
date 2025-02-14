package actividades2.actividad2x05;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import actividades2.actividad2x05.comparadores.ComparadorDni;
import actividades2.actividad2x05.comparadores.ComparadorFecha;
import actividades2.actividad2x05.comparadores.ComparadorNombre;
import entrada.Teclado;

public class Actividad_2x05 {

	public static void main(String[] args) {

		Set<Cliente> clientes = new TreeSet<Cliente>();
		datosPrueba(clientes);
		int opcion = 0;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opción: ");
			System.out.println();

			switch (opcion) {
			case 0:
				break;
			case 1:
				insertarCliente(clientes);
				break;
			case 2:
				eliminarClienteDNI(clientes);
				break;
			case 3:
				consultarClienteDNI(clientes);
				break;
			case 4:
				consultarClientesOrdenDniAsc(clientes);
				break;
			case 5:
				consultarClientesOrdenNombreAsc(clientes);
				break;
			case 6:
				consultarClientesOrdenFechaAsc(clientes);
				break;
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 6.");
				break;
			}
			System.out.println();
		} while (opcion != 0);
	}

	public static void insertarCliente(Collection<Cliente> clientes) {
		String dni = Teclado.leerCadena("DNI: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		Fecha fechaNacimiento = new Fecha(
				Teclado.leerEntero("Día: "),
				Teclado.leerEntero("Mes: "),
				Teclado.leerEntero("Año: ")
				);
		String domicilio = Teclado.leerCadena("Domicilio: ");
		String correo = Teclado.leerCadena("Correo: ");
		Double saldo = Teclado.leerReal("Saldo: ");

		Cliente cliente = new Cliente(dni, nombre, fechaNacimiento, domicilio, correo, saldo);

		if (clientes.add(cliente)) {
			System.out.println("Se ha insertado el cliente en el conjunto.");
		} else {
			System.out.println("Ya existe otro cliente con ese DNI en el conjunto.");
		}

	}

	public static void eliminarClienteDNI(Collection<Cliente> clientes) {
		String dni = Teclado.leerCadena("DNI: ");
		if (clientes.remove(new Cliente(dni))) {
			System.out.println("Se ha eliminado el cliente del conjunto.");
		} else {
			System.out.println("No existe ningún cliente con ese DNI en el conjunto.");
		}
	}

	public static void consultarClienteDNI(Collection<Cliente> clientes) {
		String dni = Teclado.leerCadena("DNI: ");
		boolean encontrado = false;
		
		Iterator<Cliente> it = clientes.iterator();
		Cliente cliente = null;
		while(it.hasNext() && !encontrado) {
			cliente = it.next();
			if (cliente.equals(new Cliente(dni))) {
				encontrado = true;
			}
		}
		
		if (encontrado) {
			System.out.println(cliente.toString());
		} else {
			System.out.println("No existe ningún cliente con ese DNI en el conjunto.");
		}
	}

	public static void consultarClientesOrdenDniAsc(Collection<Cliente> clientes) {
		if (!clientes.isEmpty()) {
			List<Cliente> aux = new LinkedList<Cliente>();
			aux.addAll(clientes);
			Collections.sort(aux, new ComparadorDni());
			
			for (Cliente cliente : aux) {
				System.out.println(cliente.toString());
			}
			
		} else {
			System.out.println("El conjunto está vacío.");
		}
	}

	public static void consultarClientesOrdenNombreAsc(Collection<Cliente> clientes) {
		if (!clientes.isEmpty()) {
			List<Cliente> aux = new LinkedList<Cliente>();
			aux.addAll(clientes);
			Collections.sort(aux, new ComparadorNombre());
			
			for (Cliente cliente : aux) {
				System.out.println(cliente.toString());
			}
			
		} else {
			System.out.println("El conjunto está vacío.");
		}
	}

	public static void consultarClientesOrdenFechaAsc(Collection<Cliente> clientes) {
		if (!clientes.isEmpty()) {
			List<Cliente> aux = new LinkedList<Cliente>();
			aux.addAll(clientes);
			Collections.sort(aux, new ComparadorFecha());
			
			for (Cliente cliente : aux) {
				System.out.println(cliente.toString());
			}
			
		} else {
			System.out.println("El conjunto está vacío.");
		}
	}
	
	public static void escribirMenuOpciones() {
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar una cliente en el conjunto.");
		System.out.println("(2) Eliminar un cliente, por DNI, del conjunto.");
		System.out.println("(3) Consultar un cliente, por DNI, del conjunto.");
		System.out.println("(4) Consultar todos los clientes del conjunto, en orden por DNI ascendente.");
		System.out.println("(5) Consultar todos los clientes del conjunto, en orden por nombre ascendente");
		System.out.println("(6) Consultar todos los clientes del conjunto, en orden por fecha de nacimiento ascendente.");
	}
	
	public static void datosPrueba(Collection<Cliente> clientes) {
		clientes.add(new Cliente("11114444B", "Elena García", new Fecha(12, 06, 2002), "Huesca", "eg@gmail.com", 43587.50));
		clientes.add(new Cliente("22225555A", "Pablo Moreno", new Fecha(23, 02, 1974), "Zaragoza", "pm@yahoo.com", 32108.69));
		clientes.add(new Cliente("33336666C", "Jorge Ruiz", new Fecha(05, 10, 1987), "Teruel", "jr@hotmail.com", 29165.28));
	}

}
