package tech.anteeone.ecobits.repositories;

import java.util.ArrayList;

public interface CrudRepository<T> {


    ArrayList<T> getAll();

    boolean create(T entity);

    boolean delete(Integer id);

    T getById(Integer id);




}
