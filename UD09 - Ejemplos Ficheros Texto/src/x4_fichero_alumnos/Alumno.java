package x4_fichero_alumnos;

public class Alumno {
	
	private static final String SEPARADOR = ";";
	
	private int codigo;
	private String nombre;
	private double nota;
	
	public Alumno(int codigo, String nombre, double nota) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public Alumno(String linea) {
		String[] datos = linea.split(SEPARADOR);
		this.codigo = Integer.parseInt(datos[0]);
		this.nombre = datos[1];
		this.nota = Double.parseDouble(datos[2]);
	}
	
	// Se utiliza para visualizar el alumno en consola.
	@Override
	public String toString() {
		return 
			String.format("Alumno [Código = %d, Nombre = %s, Nota = %.2f]", 
			              this.codigo, this.nombre, this.nota);
	}
	
	// Se utiliza para escribir el alumno en un fichero de texto.
	public String toStringWithSeparators() {
		return 
			this.codigo + SEPARADOR + 
			this.nombre + SEPARADOR + 
			String.format("%.6f", this.nota).replace(',', '.');
	}
		
}
