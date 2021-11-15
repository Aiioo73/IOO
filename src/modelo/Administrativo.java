package modelo;

import modelo.abstractions.Usuario;

import java.util.Date;

public class Administrativo extends Usuario {
    public Administrativo(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
        this.setFechaAlta(new Date());
    }

    public Administrativo() {

    }
}
