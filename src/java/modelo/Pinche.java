package modelo;

public class Pinche {

    private int id_pinche;
    private int dni;
    private String nombre;
    private String apellido;
    private int tel_fijo;
    private int tel_movil;

    public Pinche(int id_pinche) {
        this.id_pinche = id_pinche;
    }

    public int getId_pinche() {
        return id_pinche;
    }

    public void setId_pinche(int id_pinche) {
        this.id_pinche = id_pinche;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(int tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public int getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(int tel_movil) {
        this.tel_movil = tel_movil;
    }

}
