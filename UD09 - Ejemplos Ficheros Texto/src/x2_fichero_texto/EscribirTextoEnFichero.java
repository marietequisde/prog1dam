package x2_fichero_texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirTextoEnFichero {

	public static void main(String[] args) {
		FileWriter flujoSalida = null;
		try {
			File fichero = new File("frases.txt");
			flujoSalida = new FileWriter(fichero, true);
			String frase = Teclado.leerCadena("¿Frase? ");
			flujoSalida.write(frase);
			flujoSalida.write("\r\n");  // salto de línea en Windows
			System.out.println("Se ha escrito la frase \'" + frase + "\' en el fichero de texto.");
		}
		catch (IOException ioe) {
			System.out.println("Error al escribir en el fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
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
