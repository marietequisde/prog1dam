package actividades2.actividad2x02;

import actividades2.actividad2x02.excepciones.ExcepcionFecha;

public class Fecha {
	private final static String FORMATO_FECHA = ".{2}/.{2}/.{4}";

	private int dia;
	private int mes;
	private int agno;

	public Fecha(String cadena) throws ExcepcionFecha {
		if (!formatoValido(cadena)) {
			throw new ExcepcionFecha("Error al crear fecha: formato de fecha inválido.");
		}

		String[] fecha = cadena.split("/");
		this.dia = Integer.parseInt(fecha[0]);
		this.mes = Integer.parseInt(fecha[1]);
		this.agno = Integer.parseInt(fecha[2]);

	}

	public boolean esValida() throws ExcepcionFecha {
		String mensajeError = "";

		if (agno < 1583 || agno > 2999) {
			mensajeError += "año inválido, ";
		}
		if (mes < 1 || mes > 12) {
			mensajeError += "mes inválido, ";
		}
		if (dia < 1 || dia > obtenerNumeroDiasDeMes()) {
			mensajeError += "día inválido, ";
		}

		if (mensajeError.length() > 0) {
			mensajeError = "Error al validar fecha: " + mensajeError;
			mensajeError = mensajeError.substring(0, mensajeError.length() - 2);
			mensajeError += ".";
			throw new ExcepcionFecha(mensajeError);
		}

		return true;
	}

	private boolean esBisiesto() {
		boolean bisiesto = false;
		if (agno >= 1583 && (agno % 4 == 0) && (agno % 100 != 0 || agno % 400 == 0)) {
			bisiesto = true;
		}
		return bisiesto;
	}

	private int obtenerNumeroDiasDeMes() {
		int dias = 31;
		if (mes == 2) {
			if (esBisiesto()) {
				dias = 29;
			} else {
				dias = 28;
			}
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			dias = 30;

		}
		return dias;
	}

	private boolean formatoValido(String cadena) {
		return cadena.matches(FORMATO_FECHA);
	}

}
