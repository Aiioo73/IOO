package dao.abstractions;

import java.util.List;

public interface IDAO<T> {
    public void guardar(T entity);
    public void eliminar(int id);
    public List<T> listar();
    public T buscar(int id);
}
