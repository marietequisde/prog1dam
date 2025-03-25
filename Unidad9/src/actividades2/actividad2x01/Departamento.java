package actividades2.actividad2x01;

public class Departamento {

	private int codigo;
	private String nombre;
	private String ubicacion;

	public Departamento(int codigo, String nombre, String ubicacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	public Departamento(String informacion) {
		super();
		String[] campos = informacion.split(AccesoDepartamento.SEPARADOR);
		this.codigo = Integer.parseInt(campos[0]);
		this.nombre = campos[1];
		this.ubicacion = campos[2];
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
	}

	public String toStringWithSeparators() {
		return codigo + AccesoDepartamento.SEPARADOR + nombre + AccesoDepartamento.SEPARADOR + ubicacion;
	}

}
