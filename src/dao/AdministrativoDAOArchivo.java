package dao;

import dao.abstractions.BaseDAOArchivo;
import modelo.Administrativo;

public class AdministrativoDAOArchivo extends BaseDAOArchivo<Administrativo> {
    public AdministrativoDAOArchivo() {
        super(Administrativo[].class);
    }
}
