package actividades1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad1x01 {

	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		BufferedWriter flujoSalida = null;

		try {
			File fichero = new File("entrada.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
			List<String> lineas = new ArrayList<String>();
			flujoSalida = new BufferedWriter(new FileWriter(new File("salida.txt")));

			String linea = flujoEntrada.readLine();
			while (linea != null) {
				lineas.add(linea);
				linea = flujoEntrada.readLine();
			}

			for (int i = lineas.size() - 1; i >= 0; i--) {
				flujoSalida.write(lineas.get(i));
				flujoSalida.newLine();
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
				if (flujoSalida != null) {
					flujoSalida.close();
				}
			}

			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}

}
