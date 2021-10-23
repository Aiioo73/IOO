package dao.abstractions;

public interface IDAO<T> {
    void create(T entity);
    T read(Long id);
    void update(T entity);
    void delete(String entity);
}
