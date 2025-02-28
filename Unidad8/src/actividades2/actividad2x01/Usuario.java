package actividades2.actividad2x01;

import actividades2.actividad2x01.excepciones.ExcepcionUsuario;

public class Usuario {

	private final static int MIN_LEN_PASS = 6;
	private final static int MAX_LEN_PASS = 20;

	private String nombre;
	private String pass;
	private int numPuntos;

	public Usuario(String nombre, String pass, int numPuntos) throws ExcepcionUsuario {

		if (pass.length() < MIN_LEN_PASS || pass.length() > MAX_LEN_PASS) {
			throw new ExcepcionUsuario("Error al crear usuario: contraseña no tiene entre 6 y 20 caracteres.");
		}

		if (numPuntos < 0) {
			throw new ExcepcionUsuario("Error al crear usuario: número de puntos negativo.");
		}

		this.nombre = nombre;
		this.pass = pass;
		this.numPuntos = numPuntos;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", numPuntos=" + numPuntos + "]";
	}

}
