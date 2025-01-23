
public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= 500; j++) {
				if (sonAmigos(i, j)) {
					System.out.println("Los números " + i + " y " + j + " son amigos.");
				}
			}
		}
	}
	
	public static boolean sonAmigos(int numA, int numB) {
		return numA == Ejercicio7.sumarDivisores(numB) && 
			   numB == Ejercicio7.sumarDivisores(numA);
	}

}
