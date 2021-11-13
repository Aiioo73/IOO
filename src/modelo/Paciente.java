package modelo;
public class Paciente extends Usuario {
    public Paciente(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
    }
}
