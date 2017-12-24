package com.tangshengbo.controller;

import com.tangshengbo.annotation.Controller;
import com.tangshengbo.annotation.Inject;
import com.tangshengbo.annotation.RequestMapping;
import com.tangshengbo.bean.Data;
import com.tangshengbo.bean.Param;
import com.tangshengbo.model.Customer;
import com.tangshengbo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by TangShengBo on 2017/12/24.
 */
@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Inject
    private CustomerService customerService;

    @RequestMapping("get:/customer_show")
    public Data getCustomerList(Param param) {
        logger.info("执行方法");
        List<Customer> customerList = customerService.getCustomerList();
//        View view = new View("customer.jsp");
//        view.getModel().put("customerList", customerList);
        Data data = new Data();
        data.setModel(customerList);
        return data;
    }

}
