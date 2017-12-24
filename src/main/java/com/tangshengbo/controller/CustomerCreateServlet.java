package com.tangshengbo.controller;

import com.tangshengbo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TangShengBo on 2017/12/21.
 */
@WebServlet("/create")
public class CustomerCreateServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CustomerCreateServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("成功OK {}", req.getContextPath());
        CustomerService service = new CustomerService();
        req.setAttribute("customerList",  service.getCustomerList());
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req,resp);
    }
}
