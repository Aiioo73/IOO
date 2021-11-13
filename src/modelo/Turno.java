package modelo;

import modelo.abstractions.Entidad;

import java.util.Date;

public class Turno extends Entidad {

    private Odontologo docAsignado;
    private Paciente paciente;
    private int idTurno;
    private Date fechaTurno;

    public Turno(Odontologo docAsignado, Paciente paciente, int idTurno, Date fechaTurno) {
        this.docAsignado = docAsignado;
        this.paciente = paciente;
        this.idTurno = idTurno;
        this.fechaTurno = fechaTurno;
    }

    public Odontologo getDocAsignado() {
        return docAsignado;
    }

    public void setDocAsignado(Odontologo docAsignado) {
        this.docAsignado = docAsignado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
