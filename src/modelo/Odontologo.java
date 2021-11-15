package modelo;

import modelo.abstractions.Usuario;

import java.util.Date;

public class Odontologo extends Usuario {
    private int horaEntrada;
    private int horaSalida;

    public Odontologo() {

    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

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
        this.setFechaAlta(new Date());
    }

}
