package FernandezPerezMario_ev3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoFichero {

	private static final String NOMBRE_FICH_SOCIOS = "data/socios.txt";

	public static List<Socio> leerTodos() throws IOException {
		List<Socio> socios = new ArrayList<Socio>();

		BufferedReader flujoEntrada = null;
		File fichero = new File(NOMBRE_FICH_SOCIOS);

		try {
			flujoEntrada = new BufferedReader(new FileReader(fichero));

			String linea = flujoEntrada.readLine();
			while (linea != null) {
				socios.add(new Socio(linea));
				linea = flujoEntrada.readLine();
			}

		} finally {
			if (flujoEntrada != null) {
				flujoEntrada.close();
			}
		}

		return socios;
	}

	public static Socio consultarPorDni(String dni) throws IOException {
		BufferedReader flujoEntrada = null;
		File fichero = new File(NOMBRE_FICH_SOCIOS);

		try {
			flujoEntrada = new BufferedReader(new FileReader(fichero));

			String linea = flujoEntrada.readLine();
			while (linea != null) {
				Socio socio = new Socio(linea);
				if (dni.equals(socio.getDni())) {
					return socio;
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

	public static void insertar(Socio socio) throws IOException {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File(NOMBRE_FICH_SOCIOS);
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));

			flujoSalida.write(socio.toStringConValoresSeparados());
			flujoSalida.newLine();

		} finally {
			if (flujoSalida != null) {
				flujoSalida.close();
			}
		}
	}

	public static void escribirTodos(List<Socio> listaSocios) throws IOException {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File(NOMBRE_FICH_SOCIOS);
			flujoSalida = new BufferedWriter(new FileWriter(fichero, false));

			for (Socio socio : listaSocios) {
				flujoSalida.write(socio.toStringConValoresSeparados());
				flujoSalida.newLine();
			}

		} finally {
			if (flujoSalida != null) {
				flujoSalida.close();
			}
		}
	}

	public static int eliminarPorNumeroPuntos(int numeroPuntosMax) throws IOException {
		List<Socio> socios = leerTodos();

		int numEliminados = 0;
		Iterator<Socio> it = socios.iterator();
		Socio socio = null;
		while (it.hasNext()) {
			socio = it.next();
			if (socio.getNumeroPuntos() < numeroPuntosMax) {
				it.remove();
				numEliminados++;
			}
		}

		if (numEliminados > 0) {
			escribirTodos(socios);
		}

		return numEliminados;
	}

}
