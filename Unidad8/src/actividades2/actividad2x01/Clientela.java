package actividades2.actividad2x01;

import actividades2.actividad2x01.excepciones.ExcepcionClientela;

public class Clientela {

	private int indice;
	private Usuario[] usuarios;
	
	public Clientela(int capacidad) {
		usuarios = new Usuario[capacidad];
		indice = 0;
	}
	
	public void insertarUsuario(Usuario usuario) {
		if (indice == usuarios.length) {
			throw new ExcepcionClientela("Error al insertar usuario: vector de usuarios lleno.");
		}
		
		if (existeUsuario(usuario.getNombre())) {
			throw new ExcepcionClientela("Error al insertar usuario: nombre de usuario repetido.");
		}
		
		usuarios[indice++] = usuario;
	}
	
	public void eliminarUsuario(int posicion) {
		if (indice == 0) {
			throw new ExcepcionClientela("Error al eliminar usuario: vector de usuarios vacío.");
		}
		
		if (posicion < 0 || posicion >= indice) {
			throw new ExcepcionClientela("Error al eliminar usuario: posición no indica usuario en la clientela.");
		}
		
		for (int i = posicion; i < indice-1; i++) {
			usuarios[i] = usuarios[i+1];
		}
		indice--;

	}
	
	@Override
	public String toString() {
		String cadena = "";

		if (indice == 0) {
			return "La clientela está vacía.";
		}

		for (int i = 0; i < indice; i++) {
			cadena += String.format("(%d) %s\n", i, usuarios[i].toString());
		}
		
		cadena += String.format("Se han consultado %d usuarios", indice);

		return cadena;
	}
	
	private boolean existeUsuario(String nombre) {
		for (int i = 0; i < indice; i++) {
			if (usuarios[i].getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
}
