package modelo;

public class Plato {

    private int id_plato;
    private String platos;
    private String tipo;
    private double precio;

    public Plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getPlatos() {
        return platos;
    }

    public void setPlatos(String platos) {
        this.platos = platos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
