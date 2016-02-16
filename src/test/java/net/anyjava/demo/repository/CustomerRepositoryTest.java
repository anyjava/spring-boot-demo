package net.anyjava.demo.repository;

import static org.junit.Assert.assertEquals;

import net.anyjava.SpringDemoApplication;
import net.anyjava.demo.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by anyjava on 2016. 1. 18..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDemoApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Long id;

    /**
     * jajajajajajvavaa
     */
    @Before
    public void setUp() {
        Customer objCustomer = new Customer(null, "아이유", "쯔이");
        Customer customer = customerRepository.save(objCustomer);
        this.id = customer.getId();
    }

    @Test
    public void testSave() {
        Customer girlGroup = new Customer(3L, "러블리즈", "여자친구");
        Customer saveCustomer = customerRepository.save(
                new Customer(null, "러블리즈", "여자친구"));
        assertEquals(girlGroup, saveCustomer);
    }

    @Test
    public void testFindOne() {
        assertEquals(new Customer(1L, "아이유", "쯔이"),
                customerRepository.findOne(this.id));
    }
}