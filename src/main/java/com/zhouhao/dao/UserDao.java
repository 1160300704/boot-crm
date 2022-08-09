package com.zhouhao.dao;

import com.zhouhao.po.Customer;
import com.zhouhao.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findUser(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
    int createCustomer(Customer customer);
}
