package modelo;

public class Paciente {

    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private int dni;
    private String fechaAlta;
    private Usuario usuario;

    public Paciente(String nombre, String apellido, Domicilio domicilio, int dni, String fechaAlta, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


}
