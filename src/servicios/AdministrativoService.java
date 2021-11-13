package servicios;

import modelo.Administrativo;
import servicios.abstractions.IService;
import utils.DummyData;

import java.util.List;

public class AdministrativoService implements IService<Administrativo> {

    @Override
    public void guardar(Administrativo entity) {

    }

    @Override
    public Administrativo buscar(int id) {
        return DummyData.generarAdministrativos().get(1);
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Administrativo> listar() {
        return DummyData.generarAdministrativos();
    }

}
