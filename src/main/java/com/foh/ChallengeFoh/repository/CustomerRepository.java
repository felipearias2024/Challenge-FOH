package com.foh.ChallengeFoh.repository;

import com.foh.ChallengeFoh.repository.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findCustomerByCustomerId(String customerId);

    List<Customer> findAll();


}
