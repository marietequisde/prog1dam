package FernandezPerezMario_ev1;

public class Rectangulo {
	private int anchura, altura;

	public Rectangulo(int anchura, int altura) {
		super();
		this.anchura = anchura;
		this.altura = altura;
	}
	
	public Rectangulo() {
		this.anchura = generarAleatorio(2, 10);
		this.altura = generarAleatorio(2, 10);
	}
	
	public static boolean sonValidas(int anchura, int altura) {
		return anchura > 0 && altura > 0;
	}
	
	public String toString() {
		String resultado = "";
		
		for (int i = 0; i < altura; i++) {
			for (int y = 0; y < anchura; y++) {
				resultado += "*";
				if (y != anchura - 1) {
					resultado += " ";
				}
			}
			resultado += "\n";
		}
		
		return resultado;
	}
	
	private static int generarAleatorio(int desde, int hasta) {
		int random = 0;
		do {
			double randomDouble = Math.random() * 10 + desde;
			random = (int) Math.floor(randomDouble);
		} while (random > hasta);
		return random;
	}
}
