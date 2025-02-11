package com.utils.mario;
import java.util.Random;

public class RandomUtils {
	
	public static int generarAleatorio(int minimo, int maximo) {
		Random aleatorio = new Random();
		return aleatorio.nextInt(maximo - minimo + 1) + minimo;
	}
}
