import java.util.Scanner;

public class Media {

	public static void main(String[] args) {

		System.out.println(invertir2(12345678));

	}
	
	public static int invertir(int numero) {
		int retVal = 0;
		int largo = largoNumero(numero);
		
		for (int i = 0; i < largo; i++) {
			int digito = obtenerDigito(numero, i);
			retVal += digito * elevar(10, largo - i - 1);
		}
		
		return retVal;
	}
	
	public static int invertir2(int numero) {
		return invertirRecursivo(numero, 0, 0);
	}
	
	public static int invertirRecursivo(int numero, int resultado, int i) {
		if (numero == 0) {
			return resultado;
		}
		int largo = largoNumero(numero);
		
		int digito = numero % 10;
		resultado += digito * elevar(10, largo - 1);
		numero = numero / 10;
		
		return invertirRecursivo(numero, resultado, i+1);
	}
	
	public static int obtenerDigito(int numero, int digito) {
		return numero % elevar(10, digito + 1) / elevar(10, digito);
	}
	
	public static int elevar(int base, int exponente) {
		return elevarRecursivo(base, exponente, base);
	}
	
	public static int elevarRecursivo(int base, int exponente, int resultado) {
		if (exponente < 1) {
			return 1;
		}
		if (exponente == 1) {
			return resultado;
		}
		return elevarRecursivo(base, exponente-1, resultado*base);
	}
	
	public static int largoNumero(int numero) {
		return largoNumeroRecursiva(numero, 0);
	}
	
	public static int largoNumeroRecursiva(int numero, int largo) {
		if (numero == 0) {
			return largo;
		}
		return largoNumeroRecursiva(numero/10, largo+1);
	}

}
