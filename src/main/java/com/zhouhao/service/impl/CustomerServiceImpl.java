package com.zhouhao.service.impl;

import com.zhouhao.dao.CustomerDao;
import com.zhouhao.po.Customer;
import com.zhouhao.service.CustomerService;
import com.zhouhao.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, Customer customer) {
        customer.setStart((page - 1) * rows);
        customer.setRows(rows);

        List<Customer> customers = customerDao.selectCustomerList(customer);
        Integer count = customerDao.selectCustomerListCount(customer);

        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setTotal(count);
        result.setSize(rows);
        return result;
    }
}
