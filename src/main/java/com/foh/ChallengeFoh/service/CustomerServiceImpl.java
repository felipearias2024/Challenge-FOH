package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerResponse getCustomer(String customerId) {
        return null ;
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        return null;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest request) {
        return null;
    }

    @Override
    public CustomerResponse deleteCustomer(CustomerRequest request) {
        return null;
    }

    public PrimeNamesResponse getPrimeNames(){
        return null;
    }
}
