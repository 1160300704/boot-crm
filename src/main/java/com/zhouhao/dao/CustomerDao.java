package com.zhouhao.dao;

import com.zhouhao.po.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> selectCustomerList(Customer customer);
    Integer selectCustomerListCount(Customer customer);
}
