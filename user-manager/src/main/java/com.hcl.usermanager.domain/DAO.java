package com.hcl.usermanager.domain;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(Long id);
    List<T> getByProperty(String property, String match);
    T add(T entity);
    boolean delete(T entity);
    boolean delete(Long id);
    boolean update(T entity);
}
