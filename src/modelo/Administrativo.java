package modelo;

public class Administrativo extends Usuario{
    public Administrativo(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
    }
}
