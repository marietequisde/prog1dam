package actividades2.actividad2x05;

import java.util.Objects;

public class Fecha {

	private int dia;
	private int mes;
	private int anyo;
	
	public Fecha(int dia, int mes, int anyo) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
		
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnyo() {
		return anyo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anyo, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return anyo == other.anyo && dia == other.dia && mes == other.mes;
	}
	
	public int compareTo(Fecha otraFecha) {
		String esta = String.format("%04d/%02d/%02d", anyo, mes, dia);
		String otra = String.format("%04d/%02d/%02d", otraFecha.anyo, otraFecha.mes, otraFecha.dia);
		return esta.compareTo(otra);
	}

	@Override
	public String toString() {
		return String.format("%d/%d/%d", dia, mes, anyo);
	}
	
	
}
