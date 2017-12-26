package com.tangshengbo.controller;

import com.tangshengbo.annotation.Controller;
import com.tangshengbo.annotation.Inject;
import com.tangshengbo.annotation.RequestMapping;
import com.tangshengbo.bean.Data;
import com.tangshengbo.bean.Param;
import com.tangshengbo.bean.View;
import com.tangshengbo.model.Customer;
import com.tangshengbo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TangShengBo on 2017/12/24.
 */
@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Inject
    private CustomerService customerService;

    @RequestMapping("get:/customer_show")
    public View getCustomerList() {
        logger.info("执行方法 参数 {}");
        List<Customer> customerList = customerService.getCustomerList();
        View view = new View("customer.jsp");
        view.getModel().put("customerList", customerList);
        return view;
    }

    @RequestMapping("get:/customer")
    public Data getCustomerById(Param param) {
        logger.info("执行方法 参数 {}", param);
        Customer customer = customerService.getCustomer(param.getLong("id"));
        Data data = new Data();
        data.setModel(customer);
        return data;
    }

    @RequestMapping("get:/create_customer")
    public Data createCustomer() {
        logger.info("执行方法 参数 {}");
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "");
        fieldMap.put("contact", "");
        fieldMap.put("telephone", "");
        fieldMap.put("email", "");
        Object[][] o = new Object[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                o[i][j] = i + j;
            }
        }
        customerService.createCustomerBatch(fieldMap, o);
        Data data = new Data();
        data.setModel("成功");
        return data;
    }
}
