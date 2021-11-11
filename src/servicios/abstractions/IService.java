package servicios.abstractions;

import java.util.List;

public interface IService<T> {
    public void guardar(T entity);
    public T buscar(int id);
    public void eliminar(int id);
    public List<T> listar();
}
