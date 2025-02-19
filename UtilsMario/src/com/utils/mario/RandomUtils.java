package com.utils.mario;
import java.util.Random;

public class RandomUtils {
	
	public static int generarIntAleatorio(int minimo, int maximo) {
		Random aleatorio = new Random();
		return aleatorio.nextInt(maximo - minimo + 1) + minimo;
	}
	
	public static String generarStringAleatorio(int longitud) {
		String retVal = "";
		do {
			retVal += (char) generarLetraAleatoria();
			longitud--;
		} while (longitud > 0);
		
		return retVal;
	}
	
	public static char generarLetraAleatoria() {
		final String ABC = "abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return ABC.charAt(generarIntAleatorio(0, ABC.length()-1));
	}
}
