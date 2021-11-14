package servicios;

import dao.AdministrativoDAOArchivo;
import modelo.Administrativo;
import servicios.abstractions.IService;
import utils.DummyData;

import java.util.List;

public class AdministrativoService implements IService<Administrativo> {

//    @Override
//    public void guardar(Administrativo entity) {
//
//    }
//
//    @Override
//    public Administrativo buscar(int id) {
//        return DummyData.generarAdministrativos().get(1);
//    }
//
//    @Override
//    public void eliminar(int id) {
//
//    }
//
//    @Override
//    public List<Administrativo> listar() {
//        return DummyData.generarAdministrativos();
//    }

    private AdministrativoDAOArchivo dao;

    public AdministrativoService() {
        this.dao = new AdministrativoDAOArchivo();
    }

    @Override
    public void guardar(Administrativo entity) {
        dao.guardar(entity);
    }

    @Override
    public Administrativo buscar(int id) {
        return dao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    @Override
    public List<Administrativo> listar() {
        return dao.listar();
    }
}
