package servicios;

import dao.AdministrativoDAOArchivo;
import modelo.Administrativo;
import servicios.abstractions.IService;

import java.util.List;

public class AdministrativoService implements IService<Administrativo> {

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

    public Administrativo buscar(String nombreUsuario) {
        List<Administrativo> list = dao.listar();

        for (Administrativo admin: list) {
            if (admin.getNombreUsuario() == nombreUsuario) {
                return admin;
            }
        }

        return null;
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
