package servicios;

import dao.AdministrativoDAOArchivo;
import dao.PacienteDAOArchivo;
import modelo.Administrativo;
import modelo.Paciente;
import servicios.abstractions.IService;
import utils.DummyData;
import java.util.List;

public class PacienteService implements IService<Paciente> {

    private PacienteDAOArchivo dao;

    public PacienteService() {
        this.dao = new PacienteDAOArchivo();
    }

    @Override
    public void guardar(Paciente entity) {
         dao.guardar(entity);
    }

    @Override
    public Paciente buscar(int id) {
        return dao.buscar(id);
    }

    public Paciente buscar(String nombreUsuario) {
        List<Paciente> list = dao.listar();

        for (Paciente paciente: list) {
            if (paciente.getNombreUsuario() == nombreUsuario) {
                return paciente;
            }
        }

        return null;
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    @Override
    public List<Paciente> listar() {
        return dao.listar();
    }

}
