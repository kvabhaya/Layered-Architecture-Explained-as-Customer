package com.devstack.test.dao.custom;

import com.devstack.test.dao.CrudDao;
import com.devstack.test.entity.Customer;

public interface CustomerDao extends CrudDao {
    public Customer findCustomer(String id);
}
