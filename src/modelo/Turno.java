package modelo;

import modelo.abstractions.Entidad;

import java.util.Date;

public class Turno extends Entidad {

    private Odontologo docAsignado;
    private Paciente paciente;
    private int idTurno;
    private Date fechaTurno;

    public Turno(Odontologo docAsignado, Paciente paciente, Date fechaTurno) {
        this.docAsignado = docAsignado;
        this.paciente = paciente;
        this.fechaTurno = fechaTurno;
    }

    public Odontologo getDocAsignado() {
        return docAsignado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public int getHoraTurno() { return fechaTurno.getHours(); }
}
