package org.example.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/universidad";
    private static final String usuario = "root";
    private static final String pasword = "123456789";

    public static Connection conectar(){
        Connection conexion = null;
            try{
                conexion = DriverManager.getConnection(url,usuario,pasword);
                System.out.println("Conexion correcta a MySQL");
            }
            catch(SQLException err){
                System.out.println("Error al conectarse con MySQL "+ err);
            }
        return  conexion;
    }
}
