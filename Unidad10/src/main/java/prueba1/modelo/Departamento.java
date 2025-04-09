package prueba1.modelo;

public class Departamento {

        private int codigo;
	private String nombre;
	private String ubicacion;

    public Departamento(int codigo, String nombre, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + '}';
    }


}
