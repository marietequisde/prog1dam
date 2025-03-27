package FernandezPerezMario_ev3;

public class Socio {

	private String dni;
	private String nombre;
	private double cuotaMensual;
	private int numeroPuntos;

	private static final String SEPARADOR = ";";

	public Socio(String dni, String nombre, double cuotaMensual, int numeroPuntos) {
		this.dni = dni;
		this.nombre = nombre;
		this.cuotaMensual = cuotaMensual;
		this.numeroPuntos = numeroPuntos;
	}

	public Socio(String cadena) {
		String[] campos = cadena.split(SEPARADOR);
		this.dni = campos[0];
		this.nombre = campos[1];
		this.cuotaMensual = Double.parseDouble(campos[2].replace(',', '.'));
		this.numeroPuntos = Integer.parseInt(campos[3]);
	}

	@Override
	public String toString() {
		return "Socio [DNI = " + dni + ", Nombre = " + nombre + ", CuotaMensual = " + cuotaMensual + ", NumeroPuntos = "
				+ numeroPuntos + "]";
	}

	public String toStringConValoresSeparados() {
		return dni + SEPARADOR + nombre + SEPARADOR + String.format("%.2f", cuotaMensual) + SEPARADOR + numeroPuntos;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCuotaMensual() {
		return cuotaMensual;
	}

	public int getNumeroPuntos() {
		return numeroPuntos;
	}

}
