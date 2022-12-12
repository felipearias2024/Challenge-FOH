package com.foh.ChallengeFoh.repository;

import com.foh.ChallengeFoh.repository.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findCustomerByCustomerId(String customerId);

    List<Customer> findAll();

    @Query(
            nativeQuery = true,
            value = "SELECT COUNT(*) from customer where LENGTH(full_name) IN (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)"
    )
    Integer getPrimeNames();


}
