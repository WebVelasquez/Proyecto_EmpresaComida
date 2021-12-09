package modelo;

public class Estanteria {

    private int id_estanteria;
    private String estante;
    private String tamaño;
    private Almacen id_almacen;

    public Estanteria(int id_estanteria) {
        this.id_estanteria = id_estanteria;
    }

    public int getId_estanteria() {
        return id_estanteria;
    }

    public void setId_estanteria(int id_estanteria) {
        this.id_estanteria = id_estanteria;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Almacen getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(Almacen id_almacen) {
        this.id_almacen = id_almacen;
    }

}
