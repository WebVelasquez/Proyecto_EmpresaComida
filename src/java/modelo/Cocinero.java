package modelo;

public class Cocinero {

    private int id_cocinero;
    private int dni;
    private String nombres;
    private String apellidos;
    private int tel_fijo;
    private int tel_movil;
    private int anios_servicio;

    public Cocinero(int id_cocinero) {
        this.id_cocinero = id_cocinero;
    }

    public int getId_cocinero() {
        return id_cocinero;
    }

    public void setId_cocinero(int id_cocinero) {
        this.id_cocinero = id_cocinero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public int getAnios_servicio() {
        return anios_servicio;
    }

    public void setAnios_servicio(int anios_servicio) {
        this.anios_servicio = anios_servicio;
    }

}
