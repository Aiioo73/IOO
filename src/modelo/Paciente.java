package modelo;

import modelo.abstractions.Usuario;

import java.util.Date;

public class Paciente extends Usuario {
    public Paciente(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
        this.setFechaAlta(new Date());
    }
}
