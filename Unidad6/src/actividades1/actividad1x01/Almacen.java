package actividades1.actividad1x01;

public class Almacen {

	private int indice;
	private Videojuego[] videojuegos;
	
	public Almacen(int capacidad) {
		this.videojuegos = new Videojuego[capacidad];
		this.indice = 0;
	}
	
	public Videojuego consultar(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			return videojuegos[posicion];
		}
		return null;
	}
	
	public Videojuego consultar(String titulo) {
		for (int i = 0; i < indice; i++) {
			if (titulo.equals(videojuegos[i].getTitulo())) {
				return videojuegos[i];
			}
		}
		return null;
	}
	
	public Videojuego[] obtenerVideojuegos(String titulo) {
		Videojuego[] encontrados = new Videojuego[contarVideojuegos(titulo)];
		int contador = 0;
		
		for (int i = 0; i < indice; i++) {
			if (titulo.equals(videojuegos[i].getTitulo())) {
				encontrados[contador++] = videojuegos[i];
			}
		}
		
		return encontrados;
	}
	
	public Almacen obtenerAlmacen(String titulo) {
		Almacen almacen = new Almacen(contarVideojuegos(titulo));
		
		for (int i = 0; i < indice; i++) {
			if (titulo.equals(videojuegos[i].getTitulo())) {
				almacen.insertar(videojuegos[i]);
			}
		}
		
		return almacen;
	}
	
	public boolean insertar(Videojuego videojuego) {
		if (indice < videojuegos.length) {
			videojuegos[indice++] = videojuego;
			return true;
		}
		return false;
	}
	
	public boolean eliminar(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			for (int i = posicion; i <= indice - 2; i++) {
				videojuegos[i] = videojuegos[i+1];
			}
			videojuegos[indice-1] = null;
			indice--;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String cadena = "";
		
		if (indice == 0) {
			return "El almacén está vacío.";
		}
		
		for (int i = 0; i < indice; i++) {
			if (videojuegos[i] != null) {
				cadena += String.format("(%d) %s\n", i, videojuegos[i].toString());
			}
		}
		
		return cadena;
	}
	
	private int contarVideojuegos(String titulo) {
		int numEncontrados = 0;
		
		for (int i = 0; i < indice; i++) {
			if (titulo.equals(videojuegos[i].getTitulo())) {
				numEncontrados++;
			}
		}
		
		return numEncontrados;
	}
	
	
}
