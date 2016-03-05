package net.anyjava.jpa.service;

import com.mysema.query.jpa.impl.JPAQuery;
import net.anyjava.SpringDemoApplication;
import net.anyjava.jpa.domain.Address;
import net.anyjava.jpa.domain.Member;
import net.anyjava.jpa.domain.QMember;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anyjava on 2016. 2. 29..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringDemoApplication.class)
@Transactional
public class TestServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TestService testService;

    @org.junit.Before
    public void setUp() throws Exception {


        Member member = new Member();
        member.setName("anyjava");

        Address address = new Address();
        address.setCity("Jinju");
        address.setStreet("Gawjwa");
        address.setZipcode("123123");

        member.setAddress(address);


        em.persist(member);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test_테스트() {

        TypedQuery<Member> query =
                em.createQuery("SELECT m FROM Member m", Member.class);

        Member member = query.getSingleResult();

        assertEquals("anyjava", member.getName());

        testService.selectMember();

        System.out.println(em);
        assertNotNull(em);
    }

}