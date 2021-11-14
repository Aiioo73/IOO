package servicios;

import dao.TurnoDAOArchivo;
import modelo.Odontologo;
import modelo.Turno;
import servicios.abstractions.IService;

import java.util.List;

public class TurnoService implements IService<Turno> {
    private TurnoDAOArchivo dao;

    public TurnoService() {
        this.dao = new TurnoDAOArchivo();
    }

    @Override
    public void guardar(Turno entity) {
        dao.guardar(entity);
    }

    @Override
    public Turno buscar(int id) {
        return dao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    @Override
    public List<Turno> listar() {
        return dao.listar();
    }

    public List<Turno> listar(Odontologo odontologo) {
        List<Turno> lista = listar();
        lista.removeIf(turno -> turno.getDocAsignado() != odontologo);
        return lista;
    }
}
