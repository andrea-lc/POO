/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ConexionDB {
    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=cat_haven;encrypt=true;trustServerCertificate=true;";
    private static final String USUARIO = "andrea";
    private static final String CONTRASENA = "123456";
    
    private static Connection conexion;

    public static Connection obtenerConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("Conexión exitosa a la base de datos");
            }
            return conexion;
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
