package main.DAO;

import java.util.List;
import java.util.UUID;

public interface IDao<T> {
    T find(UUID id);

    List<T> findAll();

    boolean add(T object);

    boolean update(T object);

    boolean delete(UUID id);

}
