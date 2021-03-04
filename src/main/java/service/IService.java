package service;

import model.Product;

import java.util.List;

public interface IService<E> {

    List<E> findAll();

    void save(E e);

    E findById(int id);

    void update(int id, E e);

    void remove(int id);

    List<E> findByName(String name);

}