package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.util.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    /**
     * Obtains a specific customer
     * @param customerId id of the customer to be found
     * @return Customer found
     * @throws CustomerNotFoundException
     */
    CustomerResponse getCustomer(String customerId) throws CustomerNotFoundException;

    /**
     * Lists all customers
     * @return A list containing all customers
     */
    List<CustomerResponse> getAllCustomers();

    /**
     * Create a new customer
     * @param request customer data to be created
     * @return the newly created customer
     */
    CustomerResponse createCustomer(CustomerRequest request);

    /**
     * Update an existing customer
     * @param request customer data to be updated
     * @param customerId id of the customer to be updated
     * @return the newly updated customer
     * @throws CustomerNotFoundException
     */
    CustomerResponse updateCustomer(CustomerRequest request, String customerId) throws CustomerNotFoundException;

    /**
     * Delete an existing customer
     * @param customerId id of the customer to be deleted
     * @throws CustomerNotFoundException
     */
    void deleteCustomer(String customerId) throws CustomerNotFoundException;

    /**
     * Calculates the number the number of names whose number of characters corresponds to a prime number
     * @return the number of names whose number of characters corresponds
     * to a prime number
     */
    Integer getPrimeNames();
}
