package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.CustomerResponseParser;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.repository.CustomerRepository;
import com.foh.ChallengeFoh.repository.entity.Customer;
import com.foh.ChallengeFoh.util.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerResponseParser customerResponseParser;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerResponseParser customerResponseParser) {
        this.customerRepository = customerRepository;
        this.customerResponseParser = customerResponseParser;
    }

    @Override
    public CustomerResponse getCustomer(String customerId) throws CustomerNotFoundException{
        try{
            log.info("Searching for customer with customer id {}", customerId);
            Customer customer = customerRepository.findCustomerByCustomerId(customerId);
            log.info("Customer found for id {}", customerId);
            return customerResponseParser.convertEntityToResponse(customer);
        }catch (NullPointerException ex){
            log.error("Customer not found for id {}", customerId);
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        log.info("Obtaining all available customers");
        return customerResponseParser.convertEntityToResponseList(customerRepository.findAll());
    }

    @Override
    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        log.info("Creating new customer");
        Customer customer = customerResponseParser.convertCreateRequestToEntity(request);
        CustomerResponse response = customerResponseParser.convertEntityToResponse(customerRepository.save(customer));
        log.info("Customer created");
        return response;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerUpdateRequest request) throws CustomerNotFoundException{
        log.info("Updating customer");
        getCustomer(request.getCustomerId());
        Customer customer = customerResponseParser.convertUpdateRequestToEntity(request);
        CustomerResponse response = customerResponseParser.convertEntityToResponse(customerRepository.save(customer));
        log.info("Customer updated");
        return response;
    }

    @Override
    public void deleteCustomer(String customerId) throws CustomerNotFoundException{
        log.info("Deleting customer with id {}", customerId);
        getCustomer(customerId);
        customerRepository.deleteById(customerId);
        log.info("Customer deleted with id {}", customerId);
    }

    @Override
    public PrimeNamesResponse getPrimeNames() {
        List<CustomerResponse> customerList = getAllCustomers();
        List<String> primeNamesList = new ArrayList<>();
        customerList.stream().forEach(customer -> {
            int nameLength = customer.getName().length();
            boolean flag = true;
            if (nameLength == 0 || nameLength == 1) {
                flag = false;
            }
            for (int i = 2; i <= nameLength / 2; ++i) {
                if (nameLength % i == 0) {
                    flag = false;
                }
            }
            if (flag) {
                primeNamesList.add(customer.getName());
            }
        });
        return PrimeNamesResponse.builder().primeNamesAmount(primeNamesList.size()).primeNames(primeNamesList).build();
    }
}
