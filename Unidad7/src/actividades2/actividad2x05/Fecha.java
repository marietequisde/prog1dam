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
		int otroAnyo = otraFecha.getAnyo();
		int otroMes = otraFecha.getMes();
		int otroDia = otraFecha.getDia();
		
		if (dia == otroDia && mes == otroMes && anyo == otroAnyo) {
			return 0;
		}
		
		if (anyo > otroAnyo) {
			return -1;
		}
		if (mes > otroMes) {
			return -1;
		}
		if (dia > otroDia) {
			return -1;
		}

		return 1;
	}

	@Override
	public String toString() {
		return String.format("%d/%d/%d", dia, mes, anyo);
	}
	
	
}
