package net.anyjava.demo.controller;

import net.anyjava.demo.domain.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anyjava on 2016. 2. 11..
 */
@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        return null;
    }
}
