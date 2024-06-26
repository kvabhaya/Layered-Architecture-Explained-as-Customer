package com.devstack.test.dao.custom.impl;

import com.devstack.test.dao.custom.CustomerDao;
import com.devstack.test.entity.Customer;

import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer findCustomer(String id) {
        return null;
    }

    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public Object find(Object o) {
        return null;
    }

    @Override
    public List findAll() {
        return Collections.emptyList();
    }
}
