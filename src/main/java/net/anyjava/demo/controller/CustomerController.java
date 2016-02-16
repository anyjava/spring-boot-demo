package net.anyjava.demo.controller;

import net.anyjava.demo.domain.Customer;
import net.anyjava.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anyjava on 2016. 2. 11..
 */
@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.select(id);
    }
}
