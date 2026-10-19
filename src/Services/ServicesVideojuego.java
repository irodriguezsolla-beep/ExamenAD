package Services;

import Connections.Conector;
import Models.Videojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesVideojuego {
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
            System.out.println("Videojuego actualización con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

    }
    //leer
    public static List<Videojuego> leerVideojuego(){
        String sql = "SELECT * FROM  Videoxogo VALUES";
        List<Videojuego> toRet = new ArrayList<>();

        try (Connection conn = Conector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                toRet.add(new Videojuego(
                                rs.getInt("Id"),
                                rs.getString("Titulo"),
                                rs.getString("Plataforma"),
                                rs.getInt("AnoLanzamento"),
                                rs.getString("Descripcion")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return toRet;
    }

    public static void eliminarVideojuego(Videojuego v) {
        String sql = "DELETE FROM Videoxogo Where Titulo = ?";

        try (Connection conn = Conector.conexion();
             PreparedStatement delete = conn.prepareStatement(sql)) {

            delete.setString(1, v.getTitulo());


            delete.executeUpdate();
            System.out.println("Videojuego eliminado.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

    }
}
