package catalogo_videos;

import java.util.Arrays;

public class Catalogo {

	private Video[] videos;
	private int indice;

	public Catalogo(int capacidad) {
		videos = new Video[capacidad];
		indice = 0;
	}

	public boolean insertar(Video video) {
		if (indice < videos.length) {
			videos[indice++] = video;
			return true;
		}
		return false;
	}

	public String consultar() {
		return toString();
	}

	public String consultar(double minPuntuacion, double maxPuntuacion) {
		String cadena = "";

		if (indice == 0) {
			return "El catálogo está vacío.";
		}

		for (int i = 0; i < indice; i++) {
			if (entrePuntuacion(videos[i], minPuntuacion, maxPuntuacion)) {
				cadena += String.format("(%d) %s\n", i, videos[i].toString());
			}
		}

		return cadena;
	}

	public String consultar(String director) {
		String cadena = "";

		if (indice == 0) {
			return "El catálogo está vacío.";
		}

		for (int i = 0; i < indice; i++) {
			if (esDirectorPelicula(videos[i], director)) {
				cadena += String.format("(%d) %s\n", i, videos[i].toString());
			}
		}

		return cadena;
	}
	
	public String consultar(int anyoEmision) {
		String cadena = "";

		if (indice == 0) {
			return "El catálogo está vacío.";
		}

		for (int i = 0; i < indice; i++) {
			if (serieEmitidaEnAnyo(videos[i], anyoEmision)) {
				cadena += String.format("(%d) %s\n", i, videos[i].toString());
			}
		}

		return cadena;
	}
	
	public boolean actualizarPuntuacion(int codigo, double nuevaPuntuacion) {
		Video video = obtenerVideo(codigo);
		if (video != null) {
			video.setPuntuacion(nuevaPuntuacion);
			return true;
		}
		return false;
	}
	
	public boolean eliminar(int posicion) {
		if (posicion >= 0 && posicion < indice) {
			for (int i = posicion; i <= indice - 2; i++) {
				videos[i] = videos[i+1];
			}
			videos[indice-1] = null;
			indice--;
			return true;
		}
		return false;
	}
	
	public void reorganizarCatalogo() {
		reorganizarCatalogoSort();
	}

	@Override
	public String toString() {
		String cadena = "";

		if (indice == 0) {
			return "El catálogo está vacío.";
		}

		for (int i = 0; i < indice; i++) {
			cadena += String.format("(%d) %s\n", i, videos[i].toString());
		}

		return cadena;
	}
	
	public Video obtenerVideo(int codigo) {
		for (int i = 0; i < indice; i++) {
			if (codigo == videos[i].getCodigo()) {
				return videos[i];
			}
		}
		return null;
	}
	
	public boolean estaVacio() {
		return indice == 0;
	}
	
	private void reorganizarCatalogoSort() {
		Arrays.sort(videos, 0, indice);
	}
	
	private void bubbleSort() {
		for (int i = 1; i < indice; i++) {
			for (int j = 0; j < indice - i; j++) {
				if (videos[j] instanceof Serie && videos[j+1] instanceof Pelicula) {
					Video videoAux = videos[j];
					videos[j] = videos[j+1];
					videos[j+1] = videoAux;
				}	
			}
		}
	}
	
	private void partitionSort() {
		int i = 0;
		int j = indice - 1;
		
		while (i < j) {
			if (videos[i] instanceof Serie && videos[j] instanceof Pelicula) {
				Video videoAux = videos[i];
				videos[i] = videos[j];
				videos[j] = videoAux;
			}
			
			if (videos[i] instanceof Pelicula) {
				i++;
			}
			
			if (videos[j] instanceof Serie) {
				j--;
			}
		}
	}
	
	private void reorganizarCatalogoFors() {
		Video[] ordenado = new Video[videos.length];
		int contador = 0;
		
		for (int i = 0; i < indice; i++) {
			if (videos[i] instanceof Pelicula) {
				ordenado[contador++] = videos[i];
			}
		}
		
		for (int i = 0; i < indice; i++) {
			if (videos[i] instanceof Serie) {
				ordenado[contador++] = videos[i];
			}
		}
		
		videos = ordenado;
	}
	
	private boolean serieEmitidaEnAnyo(Video video, int anyo) {
		return video instanceof Serie && 
				anyo >= ((Serie) video).getAnyoInicio() &&
				anyo <= ((Serie) video).getAnyoFin();
	}
	
	private boolean esDirectorPelicula(Video video, String director) {
		return video instanceof Pelicula && 
				director.equals(((Pelicula) video).getDirector());
	}

	private boolean entrePuntuacion(Video video, double minPuntuacion, double maxPuntuacion) {
		return video.getPuntuacion() >= minPuntuacion && 
				video.getPuntuacion() <= maxPuntuacion;
	}
}
