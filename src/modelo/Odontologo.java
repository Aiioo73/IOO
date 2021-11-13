package modelo;

import modelo.abstractions.Usuario;

public class Odontologo extends Usuario {
    private int horaEntrada;
    private int horaSalida;

    public Odontologo(
            String nombreUsuario,
            String passwordHash,
            String nombreCompleto,
            String dni,
            Domicilio domicilio,
            int horaEntrada,
            int horaSalida
    ) {
        super(nombreUsuario, passwordHash, nombreCompleto, dni, domicilio);
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

}
