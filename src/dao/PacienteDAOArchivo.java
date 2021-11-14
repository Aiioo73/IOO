package dao;

import dao.abstractions.BaseDAOArchivo;
import modelo.Paciente;

public class PacienteDAOArchivo extends BaseDAOArchivo<Paciente> {
    public PacienteDAOArchivo() {
        super(Paciente[].class);
    }
}
