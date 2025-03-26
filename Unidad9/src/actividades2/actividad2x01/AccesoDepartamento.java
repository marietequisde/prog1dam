package actividades2.actividad2x01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoDepartamento {

	private static final String FICHERO = "departamentos.txt";

	public static final String SEPARADOR = ";";

	public static Departamento leer(int codigo) throws FileNotFoundException, IOException {
		BufferedReader flujoEntrada = null;
		File fichero = new File(FICHERO);

		try {
			flujoEntrada = new BufferedReader(new FileReader(fichero));

			String linea = flujoEntrada.readLine();
			while (linea != null) {
				Departamento departamento = new Departamento(linea);
				if (departamento.getCodigo() == codigo) {
					return departamento;
				}
				linea = flujoEntrada.readLine();
			}

		} finally {
			if (flujoEntrada != null) {
				flujoEntrada.close();
			}
		}

		return null;
	}

	public static List<Departamento> leerTodos() throws FileNotFoundException, IOException {
		List<Departamento> departamentos = new ArrayList<Departamento>();

		BufferedReader flujoEntrada = null;
		File fichero = new File(FICHERO);

		try {
			flujoEntrada = new BufferedReader(new FileReader(fichero));

			String linea = flujoEntrada.readLine();
			while (linea != null) {
				departamentos.add(new Departamento(linea));
				linea = flujoEntrada.readLine();
			}

		} finally {
			if (flujoEntrada != null) {
				flujoEntrada.close();
			}
		}

		return departamentos;
	}

	public static boolean insertar(Departamento nuevoDep) throws FileNotFoundException, IOException {
		List<Departamento> departamentos = leerTodos();
		for (Departamento dep : departamentos) {
			if (dep.getCodigo() == nuevoDep.getCodigo()) {
				return false;
			}
		}

		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File(FICHERO);
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));

			flujoSalida.write(nuevoDep.toStringWithSeparators());
			flujoSalida.newLine();
			return true;

		} finally {
			if (flujoSalida != null) {
				flujoSalida.close();
			}
		}
	}

	public static boolean actualizar(int codigo, String nombre, String ubicacion)
			throws FileNotFoundException, IOException {
		List<Departamento> departamentos = leerTodos();

		boolean encontrado = false;
		for (Departamento dep : departamentos) {
			if (dep.getCodigo() == codigo) {
				encontrado = true;
				dep.setNombre(nombre);
				dep.setUbicacion(ubicacion);
			}
		}

		if (encontrado) {
			insertarTodos(departamentos);
			return true;
		}

		return false;
	}

	public static boolean eliminar(int codigo) throws FileNotFoundException, IOException {
		List<Departamento> departamentos = leerTodos();

		boolean eliminado = false;
		Iterator<Departamento> it = departamentos.iterator();
		Departamento departamento = null;
		while (it.hasNext()) {
			departamento = it.next();
			if (departamento.getCodigo() == codigo) {
				it.remove();
				eliminado = true;
			}
		}

		if (eliminado) {
			insertarTodos(departamentos);
			return true;
		}

		return false;
	}

	private static void insertarTodos(List<Departamento> departamentos) throws FileNotFoundException, IOException {

		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File(FICHERO);
			flujoSalida = new BufferedWriter(new FileWriter(fichero, false));

			for (Departamento dep : departamentos) {
				flujoSalida.write(dep.toStringWithSeparators());
				flujoSalida.newLine();
			}

		} finally {
			if (flujoSalida != null) {
				flujoSalida.close();
			}
		}
	}

}
