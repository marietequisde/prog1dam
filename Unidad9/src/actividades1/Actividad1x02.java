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

import entrada.Teclado;

public class Actividad1x02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader flujoEntrada = null;
		BufferedWriter flujoSalida = null;
		File fichero = new File(Teclado.leerCadena("Fichero: "));

		if (fichero.exists()) {
			if (fichero.isFile()) {
				try {
					List<String> lineas = new ArrayList<String>();

					flujoEntrada = new BufferedReader(new FileReader(fichero));
					flujoSalida = new BufferedWriter(new FileWriter(new File("estadisticas.txt")));

					int contador = 1;
					String linea = flujoEntrada.readLine();
					int caracteresTotal = 0;
					int palabrasTotal = 0;
					while (linea != null) {
						int caracteresLinea = linea.length();
						int palabrasLinea = linea.trim().split(" ").length;
						caracteresTotal += caracteresLinea;
						palabrasTotal += palabrasLinea;

						String textoLinea = String.format("Línea %d: %d caracteres y %d palabras", contador++,
								caracteresLinea, palabrasLinea);
						lineas.add(textoLinea);
						
						linea = flujoEntrada.readLine();
					}

					String textoLinea = String.format("Total: %d líneas, %d caracteres y %d palabras", contador++,
							caracteresTotal, palabrasTotal);
					lineas.add(textoLinea);
					
					escribirFichero(flujoSalida, lineas);

				} catch (FileNotFoundException e) {
					System.out.println("El archivo no existe en el sistema de archivos.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (flujoEntrada != null) {
							flujoEntrada.close();
						}
						if (flujoSalida != null) {
							flujoSalida.close();
						}
					} catch (IOException ioe) {
						System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
						ioe.printStackTrace();
					}
				}
			} else {
				System.out.println("El archivo no es un fichero.");
			}
		} else {
			System.out.println("El archivo no existe en el sistema de archivos.");
		}

	}
	
	public static void escribirFichero(BufferedWriter flujoSalida, List<String> lineas) throws IOException {
		for (int i = 0; i < lineas.size(); i++) {
			flujoSalida.write(lineas.get(i));
			flujoSalida.newLine();
		}
	}

}
