package Actividades2;

import entrada.Teclado;

public class Actividad2x11 {

	public static void main(String[] args) {
		String palabra = leerPalabra("¿Palabra? ");
		String invertida = invertirPalabra(palabra);
		
		System.out.println(invertida);
		if (palabra.equals(invertida)) {
			System.out.printf("La palabra %s es palíndroma.", palabra);
		} else {
			System.out.printf("La palabra no %s es palíndroma.", palabra);
		}
	}
	
	public static int contarEspacios(String frase) {
		return (int) frase.chars()
							 .filter(c -> Character.isWhitespace(c))
							 .count();
	}
	
	public static String leerPalabra(String mensaje) {
		String frase = null;
		
		do {
			String fraseAux = Teclado.leerCadena(mensaje);
			if (contarEspacios(fraseAux) > 0) {
				System.out.println("La palabra no debe contener ningún espacio en blanco.");
			} else {
				frase = fraseAux;
			}
		} while (frase == null);
		
		return frase;
	}
	
	public static String invertirPalabra(String palabra) {
		return invertirPalabraRecursiva(palabra, "");
	}
	
	public static String invertirPalabraRecursiva(String palabra, String retVal) {
		if (palabra.length() == 0) {
			return retVal;
		}
		return invertirPalabraRecursiva(palabra.substring(1), palabra.charAt(0) + retVal);
	}

}
