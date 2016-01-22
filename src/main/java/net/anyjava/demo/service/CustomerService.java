package net.anyjava.demo.service;

import net.anyjava.demo.domain.Customer;
import net.anyjava.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sykim on 2016. 1. 22..
 * Service --> SP 역할
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * USP_Super_Customer_M01 이라고 이해하면 됨
     * @Transactional : BEGIN TRAN ~ COMMIT TRAN 역할
     */
    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }


}
