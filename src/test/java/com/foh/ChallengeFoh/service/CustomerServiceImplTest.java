package com.foh.ChallengeFoh.service;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
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
        CustomerCreateRequest request = CustomerCreateRequest.builder()
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
        CustomerUpdateRequest request = CustomerUpdateRequest.builder()
                .customerId("customerId")
                .name("name")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phone")
                .build();
        Customer customer = Customer.builder()
                .customerId("customerId")
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
        when(customerRepository.findCustomerByCustomerId(request.getCustomerId())).thenReturn(customer);
        when(customerResponseParser.convertUpdateRequestToEntity(request)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerResponseParser.convertEntityToResponse(customer)).thenReturn(customerResponse);

        CustomerResponse result = customerService.updateCustomer(request);

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
    public void testGetPrimeNames_ShouldReturnAtLeastOnePrime_WhenValidData() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = Customer.builder()
                .customerId("customerId")
                .name("names")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerList.add(customer);
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .customerId("customerId")
                .name("names")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerResponseList.add(customerResponse);
        List<String> primeNames = new ArrayList<>();
        primeNames.add("names");
        PrimeNamesResponse response = PrimeNamesResponse.builder()
                .primeNamesAmount(primeNames.size())
                .primeNames(primeNames)
                .build();
        when(customerRepository.findAll()).thenReturn(customerList);
        when(customerResponseParser.convertEntityToResponseList(customerList)).thenReturn(customerResponseList);

        PrimeNamesResponse result = customerService.getPrimeNames();

        assertEquals(result, response);
    }

    @Test
    public void testGetPrimeNames_ShouldReturnNoPrime_WhenValidData() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = Customer.builder()
                .customerId("customerId")
                .name("n")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerList.add(customer);
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        CustomerResponse customerResponse = CustomerResponse.builder()
                .customerId("customerId")
                .name("n")
                .lastName("lastName")
                .address("address")
                .email("email")
                .phoneNumber("phoneNumber")
                .build();
        customerResponseList.add(customerResponse);
        List<String> primeNames = new ArrayList<>();
        PrimeNamesResponse response = PrimeNamesResponse.builder()
                .primeNamesAmount(primeNames.size())
                .primeNames(primeNames)
                .build();
        when(customerRepository.findAll()).thenReturn(customerList);
        when(customerResponseParser.convertEntityToResponseList(customerList)).thenReturn(customerResponseList);

        PrimeNamesResponse result = customerService.getPrimeNames();

        assertEquals(result, response);

    }
}