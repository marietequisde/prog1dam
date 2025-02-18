package com.utils.mario;
import java.util.Random;

public class RandomUtils {
	
	public static int generarIntAleatorio(int minimo, int maximo) {
		Random aleatorio = new Random();
		return aleatorio.nextInt(maximo - minimo + 1) + minimo;
	}
	
	public static String generarStringAleatorio(int longitud) {
		final int MIN_ASCII = 0;
		final int MAX_ASCII = 63;
		
		String retVal = "";
		do {
			retVal += (char) generarIntAleatorio(MIN_ASCII, MAX_ASCII);
			longitud--;
		} while (longitud >= 0);
		
		return retVal;
	}
}
