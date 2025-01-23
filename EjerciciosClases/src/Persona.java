
public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
	private double altura;
	private boolean activo;
	
	public Persona(String nombre, String apellido, int edad, double altura, boolean activo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.altura = altura;
		this.activo = activo;
	}

	public Persona(String nombre, String apellido, int edad, double altura) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.altura = altura;
		this.activo = false;
	}
	
	public Persona() {
		this.nombre = "Recién";
		this.apellido = "Nacido";
		this.edad = 0;
		this.altura = 50.0;
		this.activo = false;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", altura=" + altura
				+ ", activo=" + activo + "]";
	}
	
}
