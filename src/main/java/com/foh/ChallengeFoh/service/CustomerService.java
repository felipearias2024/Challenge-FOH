package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;

import java.util.List;

public interface CustomerService {

    /**
     *
     * @param customerId id of the customer to be found
     * @return Customer found
     */
    CustomerResponse getCustomer(String customerId);

    /**
     *
     * @return A list containing all customers
     */
    List<CustomerResponse> getAllCustomers();

    /**
     *
     * @param request customer data to be created
     * @return the newly created customer
     */
    CustomerResponse createCustomer(CustomerCreateRequest request);

    /**
     *
     * @param request customer data to be updated
     * @return the newly updated customer
     */
    CustomerResponse updateCustomer(CustomerUpdateRequest request);

    /**
     *
     * @param customerId id of the customer to be deleted
     */
    void deleteCustomer(String customerId);

    /**
     *
     * @return the number of names whose number of characters corresponds
     * to a prime number along with the list of those names
     */
    PrimeNamesResponse getPrimeNames();
}
