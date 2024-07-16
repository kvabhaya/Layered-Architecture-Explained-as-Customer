package com.devstack.test.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T, ID>{
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public T find(ID id);
    public List<T> findAll() throws SQLException, ClassNotFoundException;
}
