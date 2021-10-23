package dao.abstractions;

public class BaseDAO<T> implements IDAO<T>{
    @Override
    public void create(T entity) {

    }

    @Override
    public T read(Long id) {
        return null;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(String entity) {

    }
}
