package modelo;

public class Odontologo extends Usuario{
    public Odontologo(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
    }
}
