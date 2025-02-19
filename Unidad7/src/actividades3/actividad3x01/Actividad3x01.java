package actividades3.actividad3x01;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeMap;

import entrada.Teclado;

public class Actividad3x01 {

	public static void main(String[] args) {
		final String FIN = "***";
		String nombre = "";
		Map<String, Integer> notas = new TreeMap<String, Integer>();

		do {
			nombre = Teclado.leerCadena("¿Nombre (" + FIN + " para terminar)? ");
			if (!nombre.equals(FIN)) {
				if (!notas.containsKey(nombre)) {
					notas.put(nombre, leerNota());
				} else {
					System.out.println("Ya existe un alumno con ese nombre en el mapa.");
				}
				
			}
		} while (!nombre.equals(FIN));
		
		iteradorClaves(notas);
		forEachClaves(notas);
		iteradorEntradas(notas);
		forEachEntradas(notas);
	}
	
	public static void iteradorClaves(Map<String, Integer> notas) {
		System.out.println("Elementos del Mapa Árbol de Alumnos (Iterador de Claves):");
		
		Set<String> claves = notas.keySet();
		Iterator<String> it = claves.iterator();
		
		while(it.hasNext()) {
			String clave = it.next();
			Integer valor = notas.get(clave);
			System.out.printf("(Nombre=%s, Nota=%d)\n", clave, valor);
		}
		System.out.println();
	}
	
	public static void forEachClaves(Map<String, Integer> notas) {
		System.out.println("Elementos del Mapa Árbol de Alumnos (Bucle for-each de Claves):");
		
		Set<String> claves = notas.keySet();
		
		for (String clave : claves) {
			Integer valor = notas.get(clave);
			System.out.printf("(Nombre=%s, Nota=%d)\n", clave, valor);
		}
		System.out.println();
	}
	
	public static void iteradorEntradas(Map<String, Integer> notas) {
		System.out.println("Elementos del Mapa Árbol de Alumnos (Iterador de Entradas):");
		
		Set<Entry<String, Integer>> entradas = notas.entrySet();
		Iterator<Entry<String, Integer>> it = entradas.iterator();
		
		while(it.hasNext()) {
			Entry<String, Integer> entrada = it.next();
			String clave = entrada.getKey();
			Integer valor = entrada.getValue();
			System.out.printf("(Nombre=%s, Nota=%d)\n", clave, valor);
		}
		System.out.println();
	}
	
	public static void forEachEntradas(Map<String, Integer> notas) {
		System.out.println("Elementos del Mapa Árbol de Alumnos (Bucle for-each de Entradas):");
		
		Set<Entry<String, Integer>> entradas = notas.entrySet();
		
		for (Entry<String, Integer> entrada : entradas) {
			String clave = entrada.getKey();
			Integer valor = entrada.getValue();
			System.out.printf("(Nombre=%s, Nota=%d)\n", clave, valor);
		}
		System.out.println();
	}
	
	public static int leerNota() {
		int nota = 0;
		do {
			nota = Teclado.leerEntero("¿Nota? ");
			if (nota < 1 || nota > 10) {
				System.out.println("La nota debe estar comprendida entre 1 y 10.");
			}
		} while (nota < 1 || nota > 10);
		
		return nota;
	}
}
