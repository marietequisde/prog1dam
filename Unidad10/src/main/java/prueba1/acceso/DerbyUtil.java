/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM1B11
 */
public class DerbyUtil {

    private static final String CONECTOR_DERBY = "org.apache.derby.client.ClientAutoloadedDriver";
    private static final String URL_CONEXION = "jdbc:derby://localhost:1527/personal";
    private static final String USUARIO = "root";
    private static final String PASS = "root";

    public static Connection abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName(CONECTOR_DERBY);
        Connection conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, PASS);
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
