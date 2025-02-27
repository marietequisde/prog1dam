package actividades2.excepciones;

public class ExcepcionUsuario extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcepcionUsuario(String mensaje) {
		super(mensaje);
	}

}
