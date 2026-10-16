package Models;

import java.io.Serializable;

public class TiendaVideojuegos implements Serializable {
    int Id;
    int IdVideoxogo;
    int PrezoMayorista;
    int PrezoVenta;
    int PorcentaxeOferta;

    public TiendaVideojuegos(int Id,int IdVideoxogo,int PrezoMayorista,int PrezoVenta,int PorcentaxeOferta){
        this.Id = Id;
        this.IdVideoxogo = IdVideoxogo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta= PorcentaxeOferta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdVideoxogo() {
        return IdVideoxogo;
    }

    public void setIdVideoxogo(int idVideoxogo) {
        IdVideoxogo = idVideoxogo;
    }

    public int getPrezoMayorista() {
        return PrezoMayorista;
    }

    public void setPrezoMayorista(int prezoMayorista) {
        PrezoMayorista = prezoMayorista;
    }

    public int getPrezoVenta() {
        return PrezoVenta;
    }

    public void setPrezoVenta(int prezoVenta) {
        PrezoVenta = prezoVenta;
    }

    public int getPorcentaxeOferta() {
        return PorcentaxeOferta;
    }

    public void setPorcentaxeOferta(int porcentaxeOferta) {
        PorcentaxeOferta = porcentaxeOferta;
    }
}
