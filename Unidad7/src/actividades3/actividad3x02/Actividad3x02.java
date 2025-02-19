package actividades3.actividad3x02;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import entrada.Teclado;

public class Actividad3x02 {
	final static int FIN = 0;

	public static void main(String[] args) {

		int nota = 0;
		Map<Integer, TreeSet<String>> notas = new TreeMap<>();

		do {
			nota = leerNota();
			if (nota != FIN) {
				String nombre = Teclado.leerCadena("¿Nombre? ");
				Set<String> nombres = notas.get(nota);
				if (nombres != null) {
					if (!nombres.contains(nombre)) {
						nombres.add(nombre);
					} else {
						System.out.println("Ya existe un alumno con ese nombre en el mapa.");
					}
				} else {
					notas.put(nota, new TreeSet<>());
					notas.get(nota).add(nombre);
				}

			}
		} while (nota != FIN);

		conjuntoClaves(notas);
		conjuntoEntradas(notas);

	}

	private static void conjuntoClaves(Map<Integer, TreeSet<String>> notas) {
		System.out.println("\nElementos del Mapa Árbol de Notas (Conjunto de Claves):");
		Set<Integer> claves = notas.keySet();
		for (Integer clave : claves) {
			TreeSet<String> nombres = notas.get(clave);
			System.out.printf("Nota=%d -->Nombres=%s\n", clave, nombres);
		}
	}

	private static void conjuntoEntradas(Map<Integer, TreeSet<String>> notas) {
		System.out.println("\nElementos del Mapa Árbol de Notas (Conjunto de Entradas):");
		for (Map.Entry<Integer, TreeSet<String>> entrada : notas.entrySet()) {
			System.out.printf("Nota=%d -->Nombres=%s\n", entrada.getKey(), entrada.getValue().toString());
		}
	}

	public static int leerNota() {
		int nota = 0;
		do {
			nota = Teclado.leerEntero("¿Nota (" + FIN + " para terminar)? ");
			if ((nota < 1 || nota > 10) && nota != FIN) {
				System.out.println("La nota debe estar comprendida entre 1 y 10.");
			}
		} while ((nota < 1 || nota > 10) && nota != FIN);

		return nota;
	}

}
