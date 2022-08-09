package com.zhouhao.service;

import com.zhouhao.po.Customer;
import com.zhouhao.utils.Page;

public interface CustomerService {
    Page<Customer> findCustomerList(Integer page, Integer rows, Customer customer);


}
