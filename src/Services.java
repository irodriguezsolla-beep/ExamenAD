import Connections.Conector;
import Models.Videojuego;
import com.sun.jdi.connect.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Services {
    public static void añadirVideojuego(Videojuego v) {
        String sql = "INSERT INTO  Videoxogo(Titulo, Plataforma,AnoLanzamento,Descripcion) VALUES (?, ?, ?, ?)";
        //hacer con gets
        try (Connection conn = Conector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1, v.getTitulo());
            toInsert.setString(2, v.getPlataforma());
            toInsert.setInt(3, v.getAnoLanzamento());
            toInsert.setString(4, v.getDescripcion());

            toInsert.executeUpdate();
            System.out.println("Videojuego insertado con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

    }

    //actualizar Videojuego
    public static void actualizarVideojuego(Videojuego v) {
        String sql = "UPDATE  Videoxogo SET (Titulo, Plataforma,AnoLanzamento,Descripcion) VALUES (?, ?, ?, ?)";
        //hacer con gets
        try (Connection conn = Conector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1, v.getTitulo());
            toInsert.setString(2, v.getPlataforma());
            toInsert.setInt(3, v.getAnoLanzamento());
            toInsert.setString(4, v.getDescripcion());

            toInsert.executeUpdate();
            System.out.println("Videojuego insertado con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

    }
    //leer
    public static void  leerVideojuego(){
        String sql = "SELECT Titulo, Plataforma,AnoLanzamento,Descripcion FROM  Videoxogo VALUES";

        try (Connection conn = Conector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet lista = ps.executeQuery()) {

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

}
