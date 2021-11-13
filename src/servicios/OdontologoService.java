package servicios;

import modelo.Odontologo;
import servicios.abstractions.IService;
import utils.DummyData;

import java.util.List;

public class OdontologoService implements IService<Odontologo> {

    @Override
    public void guardar(Odontologo entity) {

    }

    @Override
    public Odontologo buscar(int id) {
        return DummyData.generarOdontologos().get(1);
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> listar() {
        return DummyData.generarOdontologos();
    }

}
