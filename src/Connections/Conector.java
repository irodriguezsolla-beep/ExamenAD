package Connections;

import java.sql.*;

public class Conector {
    public static Connection  conexion() {
        Connection conn = null;

        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/probas";
            String usuario = "postgres";
            String contrasena = "admin";

            conn =  DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conectado");

        } catch (Exception e) {
            System.out.println("Erro na conexión: "+ e.getMessage());

        }
        return conn;
    }
}

