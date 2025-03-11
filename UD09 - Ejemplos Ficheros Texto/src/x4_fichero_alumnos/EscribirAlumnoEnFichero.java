package x4_fichero_alumnos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirAlumnoEnFichero {

	public static void main(String[] args) {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File("alumnos.txt");
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));
			int codigo = Teclado.leerNatural("¿Código del Alumno? ");
			String nombre = Teclado.leerCadena("¿Nombre del Alumno? ");
			double nota = Teclado.leerReal("¿Nota del Alumno? ");
			Alumno alumno = new Alumno(codigo, nombre, nota);
			flujoSalida.write(alumno.toStringWithSeparators());
			flujoSalida.newLine();
			System.out.println("Se ha escrito el alumno \'" + alumno.toString() + "\' en el fichero de texto.");
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
