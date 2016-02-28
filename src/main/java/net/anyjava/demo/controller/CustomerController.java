package net.anyjava.demo.controller;

import net.anyjava.demo.domain.Customer;
import net.anyjava.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anyjava on 2016. 2. 11..
 */
@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 고객조회 API
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {

        Customer customer = customerService.select(id);

        // 조회결과가 없을경우 404 리턴
        if ( customer == null ) {
            throw new UserNotFoundException(id);
        }

        return customer;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(Long userId) {
            super("could not find user '" + userId + "'.");
        }
    }
}
