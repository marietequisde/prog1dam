package acceso;

import java.util.HashMap;
import java.util.Map;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

import modelo.Departamento;

public class AccesoDepartamento {
	private static final String NOMBRE_BBDD_PERSONAL = "data\\personal.db";

	public static void insertar(Departamento departamento) throws ODBRuntimeException {
		ODB odb = null;
		try {
			odb = ODBFactory.open(NOMBRE_BBDD_PERSONAL);
			odb.store(departamento);
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public static Departamento consultar(int codigo) {
		ODB odb = null;
		try {
			odb = ODBFactory.open(NOMBRE_BBDD_PERSONAL);
			OID oid = OIDFactory.buildObjectOID(codigo);
			odb.getObjectFromId(oid);
			return (Departamento) odb.getObjectFromId(oid);

		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public static Map<Integer, Departamento> consultarTodos() {
		Map<Integer, Departamento> departamentos = new HashMap<Integer, Departamento>();
		ODB odb = null;
		try {
			odb = ODBFactory.open(NOMBRE_BBDD_PERSONAL);

			Objects<Departamento> coleccionDepartamentos = odb.getObjects(Departamento.class);

			while (coleccionDepartamentos.hasNext()) {
				Departamento departamento = coleccionDepartamentos.next();
				OID oid = odb.getObjectId(departamento);
				departamentos.put(Integer.parseInt(oid.toString()), departamento);
			}
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
		return departamentos;
	}

	public static Departamento actualizar(int codigo, String nombre, String ubicacion) {
		ODB odb = null;

		try {
			odb = ODBFactory.open(NOMBRE_BBDD_PERSONAL);
			OID oid = OIDFactory.buildObjectOID(codigo);
			Departamento departamento = (Departamento) odb.getObjectFromId(oid);
			departamento.setNombre(nombre);
			departamento.setUbicacion(ubicacion);
			odb.store(departamento);
			return departamento;
		}

		finally {
			if (odb != null) {
				odb.close();
			}
		}
	}
}
