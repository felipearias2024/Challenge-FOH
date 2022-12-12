package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.CustomerResponseParser;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.repository.CustomerRepository;
import com.foh.ChallengeFoh.repository.entity.Customer;
import com.foh.ChallengeFoh.util.exception.CustomerNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerResponseParser customerResponseParser;

    @Test
    public void testGetCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        Customer customer = Customer.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerResponse response = CustomerResponse.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        when(customerRepository.findCustomerByCustomerId(customerId)).thenReturn(customer);
        when(customerResponseParser.convertEntityToResponse(customer)).thenReturn(response);

        CustomerResponse result = customerService.getCustomer(customerId);

        assertEquals(result, response);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testGetCustomer_ShouldThrowCustomerNotFoundException() {
        String customerId = "customerId";

        doThrow(NullPointerException.class).when(customerRepository).findCustomerByCustomerId(customerId);

        customerService.getCustomer(customerId);

    }

    @Test
    public void testGetAllCustomers_ShouldSucceedWhenValidData() {
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
        when(customerRepository.findAll()).thenReturn(customerList);
        when(customerResponseParser.convertEntityToResponseList(customerList)).thenReturn(customerResponseList);

        List<CustomerResponse> result = customerService.getAllCustomers();

        assertEquals(result, customerResponseList);
    }

    @Test
    public void testCreateCustomer_ShouldSucceedWhenValidData() {
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phone")
                .build();
        Customer customer = Customer.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        when(customerResponseParser.convertCreateRequestToEntity(request)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerResponseParser.convertEntityToResponse(customer)).thenReturn(customerResponse);

        CustomerResponse result = customerService.createCustomer(request);

        assertEquals(result, customerResponse);
    }

    @Test
    public void testUpdateCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        CustomerRequest request = CustomerRequest.builder()
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phone")
                .build();
        Customer customer = Customer.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .customerId(customerId)
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        when(customerRepository.findCustomerByCustomerId(customerId)).thenReturn(customer);
        when(customerResponseParser.convertUpdateRequestToEntity(request, customerId)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerResponseParser.convertEntityToResponse(customer)).thenReturn(customerResponse);

        CustomerResponse result = customerService.updateCustomer(request, customerId);

        assertEquals(result, customerResponse);
    }

    @Test
    public void testDeleteCustomer_ShouldSucceed_WhenValidData() {
        String customerId = "customerId";
        Customer customer = Customer.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        when(customerRepository.findCustomerByCustomerId(customerId)).thenReturn(customer);
        doNothing().when(customerRepository).deleteById(customerId);

        customerService.deleteCustomer(customerId);

        verify(customerRepository, times(1)).deleteById(customerId);
    }


    @Test
    public void testGetPrimeNames_ShouldReturnNoPrime_WhenValidData() {
        Integer response = 2;
        when(customerRepository.getPrimeNames()).thenReturn(2);

        Integer result = customerService.getPrimeNames();

        assertEquals(result, response);

    }
}