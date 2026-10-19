package Services;


import Connections.Conector;
import Models.TiendaVideojuegos;
import Models.Videojuego;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesInventarioTienda {
    public static void añadirInventarioTenda(TiendaVideojuegos t) {
        String sql = "INSERT INTO InventarioTenda (IdVideoxogo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        //hacer con gets
        try (Connection conn = Conector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setInt(1, t.getIdVideoxogo());
            toInsert.setDouble(2, t.getPrezoMayorista());
            toInsert.setDouble(3, t.getPrezoVenta());
            toInsert.setInt(4, t.getPorcentaxeOferta());

            toInsert.executeUpdate();
            System.out.println("Insertado con exito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

    }

    //actualizar Videojuego
    public static void actualizarInventarioTenda(TiendaVideojuegos t) {
        String sql = "UPDATE  InventarioTenda SET (IdVideoxogo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        //hacer con gets
        try (Connection conn = Conector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setInt(1, t.getIdVideoxogo());
            toInsert.setDouble(2, t.getPrezoMayorista());
            toInsert.setDouble(3, t.getPrezoVenta());
            toInsert.setInt(4, t.getPorcentaxeOferta());

            toInsert.executeUpdate();
            System.out.println("Videojuego actualización con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

    }
    //leer
    public static List<TiendaVideojuegos> leerInvetarioTenda(){
        String sql = "SELECT * FROM  InvetarioTenda VALUES";
        List<TiendaVideojuegos> toRet = new ArrayList<>();

        try (Connection conn = Conector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                toRet.add(new TiendaVideojuegos(
                                rs.getInt("IdVideoxogo"),
                                rs.getDouble("PrezoMayorista"),
                                rs.getDouble("PrezoVenta"),
                                rs.getInt("PorcentaxeOferta")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return toRet;
    }

    public static void eliminarInvetarioTenda(TiendaVideojuegos t) {
        String sql = "DELETE FROM Videoxogo Where Titulo = ?";

        try (Connection conn = Conector.conexion();
             PreparedStatement delete = conn.prepareStatement(sql)) {

            delete.setInt(1, t.getIdVideoxogo());


            delete.executeUpdate();
            System.out.println("Videojuego eliminado.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

    }




}