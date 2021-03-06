package com.ecamstore.controller.admin;

import com.ecamstore.model.Customer;
import com.ecamstore.model.Product;
import com.ecamstore.service.CustomerService;
import com.ecamstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Yuth on 12/8/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }
}
