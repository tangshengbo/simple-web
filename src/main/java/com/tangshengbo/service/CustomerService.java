package com.tangshengbo.service;

import com.tangshengbo.dao.DatabaseHelper;
import com.tangshengbo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TangShengBo on 2017/12/21.
 */
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        logger.info("获取客户列表 开始.............");
        Connection conn = null;
        List<Customer> customerList = new ArrayList<>();
        String sql = "select * from customer";
        try {
            conn = DatabaseHelper.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rt = pst.executeQuery();
            while (rt.next()) {
                Customer customer = new Customer();
                customer.setId(rt.getLong("id"));
                customer.setName(rt.getString("name"));
                customer.setEmail(rt.getString("email"));
                customer.setTelephone(rt.getString("telephone"));
                customer.setRemark(rt.getString("remark"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            logger.error("执行sql异常:{}", e);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
        return customerList;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return false;
    }
}
