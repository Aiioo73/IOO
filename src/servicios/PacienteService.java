package servicios;

import modelo.Paciente;
import servicios.abstractions.IService;
import utils.DummyData;
import java.util.List;

public class PacienteService implements IService<Paciente> {

    @Override
    public void guardar(Paciente entity) {

    }

    @Override
    public Paciente buscar(int id) {
        return DummyData.pacientesDeEjemplo().get(1);
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Paciente> listar() {
        return DummyData.pacientesDeEjemplo();
    }

}
