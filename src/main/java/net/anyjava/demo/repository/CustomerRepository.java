package net.anyjava.demo.repository;

import net.anyjava.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by anyjava on 2016. 1. 18..
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query("SELECT X FROM Customer X ORDER BY x.firstName, x.lastName")
//    List<Customer> findAllOrderByName();
}
