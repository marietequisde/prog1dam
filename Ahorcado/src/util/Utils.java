package util;

import java.util.Random;

public class Utils {

	public static <T> T obtenerPosicionAleatoria(T[] vector) {
		Random aleatorio = new Random();
		int pos = aleatorio.nextInt(vector.length);
		return vector[pos];
	}
	
	public static String repetirCaracter(char caracter, int veces) {
		String retVal = "";
		
		for (int i = 0; i < veces; i++) {
			retVal += String.valueOf(caracter);
		}
		
		return retVal;
		
	}
	
	public static boolean contieneCaracterIgnoreCase(String cadena, char caracter) {
		return cadena.toUpperCase().contains(String.valueOf(Character.toUpperCase(caracter)));
	}
}
