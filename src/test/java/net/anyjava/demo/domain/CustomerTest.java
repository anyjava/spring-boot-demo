package net.anyjava.demo.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 고객 정보 엔티티
 */
public class CustomerTest {

    @Test
    public void testCustomerTest() {
        Customer customer = new Customer();

        customer.setId(1);
        assertEquals(Integer.valueOf(1), customer.getId());

        customer.setFirstName("아이유");
        assertEquals("아이유", customer.getFirstName());

        customer.setLastName("쯔이");
        assertEquals("쯔이", customer.getLastName());
    }
}