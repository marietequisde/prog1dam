package x1_archivos;

import java.io.File;
import entrada.Teclado;

public class MostrarArchivosDeDirectorio1 {
	
	public static void main(String[] args) {
		String nombreDirectorio = Teclado.leerCadena("¿Nombre del Directorio? ");
		File directorio = new File(nombreDirectorio);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				String[] vectorNombres = directorio.list();
				System.out.println("El directorio \'" + nombreDirectorio + 
				                   "\' tiene " + vectorNombres.length + " archivos.");
				for (int posicion = 0 ; posicion < vectorNombres.length ; posicion++) {
					File file = new File(directorio, vectorNombres[posicion]);
					System.out.printf("Nombre = %s, ¿Es Fichero? = %b, ¿Es Directorio? = %b \n", 
					                  vectorNombres[posicion], file.isFile(), file.isDirectory());
				}
			}
			else {
				System.out.println("El archivo no es un directorio.");
			}
		}
		else {
			System.out.println("El archivo no existe.");
		}
	}
	
}
