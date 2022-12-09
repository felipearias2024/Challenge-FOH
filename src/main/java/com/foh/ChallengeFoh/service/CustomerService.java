package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;

import java.util.List;

/**
 *
 */
public interface CustomerService {
    /**
     *
     * @param customerId
     * @return
     */
    CustomerResponse getCustomer(String customerId);

    /**
     *
     * @return
     */
    List<CustomerResponse> getAllCustomers();

    /**
     *
     * @param request
     * @return
     */
    CustomerResponse createCustomer(CustomerRequest request);

    /**
     *
     * @param request
     * @return
     */
    CustomerResponse updateCustomer(CustomerRequest request);

    /**
     *
     * @param request
     * @return
     */
    CustomerResponse deleteCustomer(CustomerRequest request);
}
