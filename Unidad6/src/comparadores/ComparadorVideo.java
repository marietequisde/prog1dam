package comparadores;

import java.util.Comparator;

import catalogo_videos.Pelicula;
import catalogo_videos.Serie;
import catalogo_videos.Video;

public class ComparadorVideo implements Comparator<Video> {

	@Override
	public int compare(Video v1, Video v2) {
		if (v1 instanceof Pelicula && v2 instanceof Serie) {
			return -1;
		}
		if (v1 instanceof Serie && v2 instanceof Pelicula) {
			return 1;
		}
		return v1.getTitulo().compareToIgnoreCase(v2.getTitulo());
	}

}
