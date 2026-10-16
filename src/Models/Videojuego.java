package Models;

import java.io.Serializable;

public class Videojuego implements Serializable {
    int Id;
    String Titulo;
    String Plataforma;
    int AnoLanzamento;
    String Descripcion;

    public Videojuego(int Id, String Titulo, String Plataforma, int AnoLanzameto, String Descripcion){
        this.Id = Id;
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzameto;
        this.Descripcion = Descripcion;
    }
    public Videojuego(String Titulo, String Plataforma, int AnoLanzameto, String Descripcion){
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzameto;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String plataforma) {
        Plataforma = plataforma;
    }

    public int getAnoLanzamento() {
        return AnoLanzamento;
    }

    public void setAnoLanzamento(int anoLanzamento) {
        AnoLanzamento = anoLanzamento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
