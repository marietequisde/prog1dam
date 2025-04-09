package prueba1.acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import prueba1.modelo.Departamento;

public class AccesoDepartamento {

    public static void insertar(Departamento departamento) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        
        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaInsert = String.format("INSERT INTO departamento (nombre, ubicacion) VALUES ('%s', '%s')", departamento.getNombre(), departamento.getUbicacion());
            Statement sentencia = conexion.createStatement();
            
            sentencia.executeUpdate(sentenciaInsert);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }

    public static Departamento consultar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Departamento departamento = null;
        
        try {
            conexion = DerbyUtil.abrirConexion();
            
            String sentenciaConsultar = String.format("SELECT * FROM departamento WHERE codigo = %d", codigo);
            Statement sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery(sentenciaConsultar);
            if (resultado.next()) {
                departamento = new Departamento(resultado.getInt("codigo"),
                                                            resultado.getString("nombre"),
                                                            resultado.getString("ubicacion"));
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return departamento;
    }

    public static List<Departamento> consultarTodos() throws ClassNotFoundException, SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        Connection conexion = null;
        
        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaConsultar = "SELECT * FROM departamento";
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);

            while (resultados.next()) {
                Departamento departamento = new Departamento(resultados.getInt("codigo"),
                        resultados.getString("nombre"),
                        resultados.getString("ubicacion"));
                departamentos.add(departamento);
            }

            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return departamentos;
    }

    public static boolean actualizar(int codigo, String nombre, String ubicacion) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean modificado = false;
        
        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaActualizar = String.format("UPDATE departamento "
                                                        + "SET nombre = '%s', ubicacion = '%s'"
                                                        + "WHERE codigo = %d", nombre, ubicacion, codigo);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                modificado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return modificado;
    }

    public static boolean eliminar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean eliminado = false;
        
        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaActualizar = String.format("DELETE FROM departamento "
                                                        + "WHERE codigo = %d", codigo);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                eliminado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return eliminado;
    }
}
