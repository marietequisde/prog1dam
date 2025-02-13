package actividades2.actividad2x05;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
	
	private String dni;
	private String nombre;
	private Fecha fechaNacimiento;
	private String domicilio;
	private String correo;
	private Double saldo;
	
	public Cliente(String dni) {
		super();
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Cliente(String dni, String nombre, Fecha fechaNacimiento, String domicilio, String correo, Double saldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.correo = correo;
		this.saldo = saldo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(correo, dni, domicilio, fechaNacimiento, nombre, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return String.format("Cliente [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", domicilio="
				+ domicilio + ", correo=" + correo + ", saldo=%.2f", saldo);
	}

	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.dni);
	}
	
	
	
}
