package net.anyjava.demo.service;

import static org.junit.Assert.assertEquals;

import net.anyjava.SpringDemoApplication;
import net.anyjava.demo.domain.Customer;
import net.anyjava.demo.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sykim on 2016. 1. 22..
 * @SpringApplicationConfiguration : Spring의 bean설정을 Loading
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDemoApplication.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() {

        Customer customer = new Customer(null, "강", "현구");

        Customer created = customerService.create(customer);

        customer.setId(1);

        assertEquals(customer, created);
    }
}