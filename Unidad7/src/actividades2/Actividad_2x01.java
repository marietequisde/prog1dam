package actividades2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.utils.mario.RandomUtils;

import entrada.Teclado;

public class Actividad_2x01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hashEnteros = new HashSet<Integer>();
		Set<Integer> linkedHastEnteros = new LinkedHashSet<Integer>();
		Set<Integer> treeEnteros = new TreeSet<Integer>();
		
		int numEnteros = Teclado.leerEntero("¿Cantidad de Números Enteros? ");
		System.out.printf("Se van a generar %d números enteros.\n", numEnteros);
		System.out.println("Insertando:");
		
		for (int i = 0; i < numEnteros; i++) {
			Integer numero = RandomUtils.generarAleatorio(10, 20);
			System.out.printf("%d * ", numero);
		}
		
	}
}
