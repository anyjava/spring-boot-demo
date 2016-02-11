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

    private Customer resultCustomer;
    private Integer resultCustomerId;

    /**
     * 테스트 전 기본 객체 생성
     */
    @Before
    @Transactional
    public void setUp() throws Exception {
        Customer defaultCustomer = this.customerFactory(null);
        this.resultCustomer = customerRepository.save(defaultCustomer);
        this.resultCustomerId = this.resultCustomer.getId();
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

        Customer customer = this.customerFactory(null);
        Customer created = customerService.create(customer);

        assertEquals(this.customerFactory(this.resultCustomerId + 1), created);
    }

    @Test
    public void testRead() {
        Customer readCustomer = customerService.find(this.resultCustomerId);
        assertEquals(this.resultCustomer, readCustomer);
    }

    private Customer customerFactory(Integer id) {
        return new Customer(id, "강", "현구");
    }
}