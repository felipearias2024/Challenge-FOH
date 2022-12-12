package com.foh.ChallengeFoh.controller.response;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.repository.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerResponseParserTest {

    @InjectMocks
    private CustomerResponseParser customerResponseParser;

    @Test
    public void testConvertEntityToResponse_ShouldSucceed_WhenValidData() {
        Customer customer = Customer.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerResponse response = CustomerResponse.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();

        CustomerResponse result = customerResponseParser.convertEntityToResponse(customer);

        assertEquals(result, response);
    }

    @Test
    public void testConvertUpdateRequestToEntity_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        Customer customer = Customer.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();

        Customer result = customerResponseParser.convertUpdateRequestToEntity(request, customerId);

        assertEquals(result, customer);

    }

    @Test
    public void testConvertCreateRequestToEntity_ShouldSucceed_WhenValidData() {
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        Customer customer = Customer.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();

        Customer result = customerResponseParser.convertCreateRequestToEntity(request);

        assertEquals(result, customer);
    }

    @Test
    public void testConvertEntityToResponseList_ShouldSucceed_WhenValidData() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = Customer.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerList.add(customer);
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerResponseList.add(customerResponse);

        List<CustomerResponse> result = customerResponseParser.convertEntityToResponseList(customerList);

        assertEquals(result, customerResponseList);
    }
}