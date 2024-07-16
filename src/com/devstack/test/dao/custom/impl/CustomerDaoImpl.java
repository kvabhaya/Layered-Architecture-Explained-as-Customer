package com.devstack.test.dao.custom.impl;

import com.devstack.test.dao.CrudUtil;
import com.devstack.test.dao.custom.CustomerDao;
import com.devstack.test.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer findCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM customer WHERE id=?", id);
        if(set.next()){
            return toCustomer(set);
        }
        return null;
    }

    @Override
    public boolean create(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO customer VALUES (?,?,?,?)",
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "UPDATE customer SEt name=?, address=? salary=? WHERE id=?",
                customer.getName(),
                customer.getAddress(),
                customer.getSalary(),
                customer.getId()
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE customer WHERE id=?",s);
    }

    @Override
    public Object find(String s) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM customer WHERE id=?", s);
        if(set.next()){
            return toCustomer(set);
        }
        return null;
    }

    @Override
    public List findAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM customer");
        List<Customer> list = new ArrayList<>();
        while(set.next()){
            list.add(toCustomer(set));
        }
        return list;
    }

    private Customer toCustomer(ResultSet set) throws SQLException {
        return new Customer(
                set.getString(1),
                set.getString(2),
                set.getString(3),
                set.getDouble(4));
    }
}
