package com.example.webcustomertracker.web;


import com.example.webcustomertracker.dao.CustomerDao;
import com.example.webcustomertracker.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerDao.getCustomers();
        theModel.addAttribute("customers",theCustomers);


        return "list-customers";
    }


}
