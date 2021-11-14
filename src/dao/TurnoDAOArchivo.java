package dao;

import dao.abstractions.BaseDAOArchivo;
import modelo.Administrativo;
import modelo.Turno;

public class TurnoDAOArchivo extends BaseDAOArchivo<Turno> {
    public TurnoDAOArchivo() {
        super(Turno[].class);
    }
}
