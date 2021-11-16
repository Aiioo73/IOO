package servicios;

import dao.OdontologoDAOArchivo;
import modelo.Odontologo;
import modelo.Paciente;
import servicios.abstractions.IService;

import java.util.List;

public class OdontologoService implements IService<Odontologo> {
    private OdontologoDAOArchivo dao;

    public OdontologoService() {
        this.dao = new OdontologoDAOArchivo();
    }

    @Override
    public void guardar(Odontologo entity) {
        dao.guardar(entity);
    }

    @Override
    public Odontologo buscar(int id) {
        return dao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    @Override
    public List<Odontologo> listar() {
        return dao.listar();
    }

    public Odontologo buscar(String nombreCompleto) {
        List<Odontologo> odontologos = listar();

        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNombreCompleto().equals(nombreCompleto)) {
                return odontologo;
            }
        }

        return null;
    }
}
