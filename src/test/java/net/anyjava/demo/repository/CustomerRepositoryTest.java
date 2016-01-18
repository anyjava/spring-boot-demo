package net.anyjava.demo.repository;

import net.anyjava.SpringDemoApplication;
import net.anyjava.demo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by anyjava on 2016. 1. 18..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDemoApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testSave() {
        Customer customer1 = new Customer(null, "아이유", "쯔이");
        System.out.println(customer1);
        System.out.println(customerRepository);
        Customer customer = customerRepository.save(customer1);
        System.out.println(customer);

        assertEquals(new Customer(1, "아이유", "쯔이"), customer);
    }

}