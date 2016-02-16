package net.anyjava.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sykim on 2016. 1. 22..
 * @SpringApplicationConfiguration : Spring의 bean설정을 Loading
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDemoApplication.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    private Customer createdCustomer;
    private Long maxId;


    @Before
    @Transactional
    public void setUp() throws Exception {
        createdCustomer = customerService.create(getCustomer());
        this.maxId = createdCustomer.getId();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * JPA의 객체는 같은 아이디일 경우 공유된다.
     * 싱글톤 느낌
     */
    @Test
    public void testCreate() {
        Customer customer = getCustomer();
        Customer target = getCustomer();
        target.setId(this.maxId+1L);

        assertEquals(target, customerService.create(customer));
    }

    @Test
    public void testSelectOne() {
        Customer target = getCustomer();
        target.setId(this.maxId);
        assertEquals(target, customerService.select(this.maxId));
    }

    @Test
    public void testUpdate() {
        Customer customer = customerService.select(this.maxId);
        customer.setFirstName("아");
        customer.setLastName("이유");

        assertEquals(new Customer(this.maxId, "아", "이유"), customer);
//        assertEquals(new Customer(this.maxId, "아", "이유"), customerService.update(customer));
    }

    @Test
    public void testDelete() {
        assertTrue(customerService.delete(this.maxId));
        assertFalse(customerService.delete(this.maxId));
    }



    private Customer getCustomer() {
        return new Customer(null, "강", "현구");
    }
}