
public class Contacto {

	private static int contador = 0;
	
	private int codigo;
	private String nombre;
	private String telefono;
	private String email;
	
	public Contacto(String nombre, String telefono, String email) {
		Contacto.contador++;
		
		this.codigo = Contacto.contador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contacto [codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ "]";
	}
	
	
	
}
