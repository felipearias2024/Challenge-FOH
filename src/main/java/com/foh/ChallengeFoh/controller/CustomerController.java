package com.foh.ChallengeFoh.controller;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer(
            @PathVariable("customerId") String customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping()
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping()
    public CustomerResponse createCustomer(
            @Validated @RequestBody CustomerCreateRequest request){
        return customerService.createCustomer(request);
    }

    @PutMapping()
    public CustomerResponse updateCustomer(
            @Validated @RequestBody CustomerUpdateRequest request){
        return customerService.updateCustomer(request);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") String customerId){
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/primes")
    public PrimeNamesResponse getPrimeNames(){
        return customerService.getPrimeNames();
    }
}
