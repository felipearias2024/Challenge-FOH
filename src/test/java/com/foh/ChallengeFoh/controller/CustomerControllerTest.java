package com.foh.ChallengeFoh.controller;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;


    @Test
    public void testGetCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        CustomerResponse response = CustomerResponse.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        when(customerService.getCustomer(customerId)).thenReturn(response);

        CustomerResponse result = customerController.getCustomer(customerId);

        assertEquals(result, response);
    }

    @Test
    public void testGetAllCustomers_ShouldSucceed_WhenValidData() {
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        CustomerResponse response = CustomerResponse.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerResponseList.add(response);
        when(customerService.getAllCustomers()).thenReturn(customerResponseList);

        List<CustomerResponse> result = customerController.getAllCustomers();

        assertEquals(result, customerResponseList);
    }

    @Test
    public void testCreateCustomer_ShouldSucceed_WhenValidData() {
        CustomerResponse response = CustomerResponse.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phone")
                .build();
        when(customerService.createCustomer(request)).thenReturn(response);

        CustomerResponse result = customerController.createCustomer(request);

        assertEquals(result, response);
    }

    @Test
    public void testUpdateCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        CustomerResponse response = CustomerResponse.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phone")
                .build();
        when(customerService.updateCustomer(request, customerId)).thenReturn(response);

        CustomerResponse result = customerController.updateCustomer(request, customerId);

        assertEquals(result, response);
    }

    @Test
    public void testDeleteCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";

        doNothing().when(customerService).deleteCustomer(customerId);

        customerController.deleteCustomer(customerId);

        verify(customerService, times(1)).deleteCustomer(customerId);
    }

    @Test
    public void testGetPrimeNames_ShouldSucceed_WhenValidData() {
        Integer response = 2;

        when(customerService.getPrimeNames()).thenReturn(response);

        Integer result = customerController.getPrimeNames();

        assertEquals(result, response);
    }
}