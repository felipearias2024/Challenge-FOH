package com.foh.ChallengeFoh.controller;

import com.foh.ChallengeFoh.controller.request.CustomerCreateRequest;
import com.foh.ChallengeFoh.controller.request.CustomerUpdateRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.controller.response.PrimeNamesResponse;
import com.foh.ChallengeFoh.service.CustomerService;
import com.foh.ChallengeFoh.util.exception.CustomerNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer (
            @PathVariable("customerId") String customerId) throws CustomerNotFoundException {
        return customerService.getCustomer(customerId);
    }

    @GetMapping()
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping()
    public CustomerResponse createCustomer(
            @RequestBody CustomerCreateRequest request){
        return customerService.createCustomer(request);
    }

    @PutMapping()
    public CustomerResponse updateCustomer(
            @RequestBody CustomerUpdateRequest request) throws CustomerNotFoundException{
        return customerService.updateCustomer(request);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") String customerId) throws CustomerNotFoundException{
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/primes")
    public PrimeNamesResponse getPrimeNames(){
        return customerService.getPrimeNames();
    }
}
