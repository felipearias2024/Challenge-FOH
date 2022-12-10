package com.foh.ChallengeFoh.controller.response;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
import com.foh.ChallengeFoh.repository.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerResponseParser {

    public CustomerResponse convertEntityToResponse(Customer customer) {
        return CustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public Customer convertRequestToEntity(CustomerUpdateRequest request) {
        return Customer.builder()
                .customerId(request.getCustomerId())
                .name(request.getName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public Customer convertRequestToEntity(CustomerCreateRequest request) {
        return Customer.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public List<CustomerResponse> convertEntityToResponseList(List<Customer> customerList){
        return customerList
                .stream()
                .map(customer -> {
                    return CustomerResponse.builder()
                            .customerId(customer.getCustomerId())
                            .name(customer.getName())
                            .lastName(customer.getLastName())
                            .address(customer.getAddress())
                            .email(customer.getEmail())
                            .phoneNumber(customer.getPhoneNumber())
                            .build();
                }).collect(Collectors.toList());
    }
}
