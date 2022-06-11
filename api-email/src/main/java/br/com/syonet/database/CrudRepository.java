package br.com.syonet.database;

import java.util.List;

public interface CrudRepository<T> {
    List<T> list();

    T save(T T);

    T findById(Long id);
}