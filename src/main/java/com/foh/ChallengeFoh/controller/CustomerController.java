package com.foh.ChallengeFoh.controller;

import com.foh.ChallengeFoh.controller.request.CustomerRequest;
import com.foh.ChallengeFoh.controller.response.CustomerResponse;
import com.foh.ChallengeFoh.service.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer(
            @PathVariable("customerId") String customerId){
        return null;
    }

    @GetMapping()
    //TODO usar estructura paginada en vez de lista
    public List<CustomerResponse> getAllCustomers(){
        return null;
    }

    @PostMapping()
    public CustomerResponse createCustomer(
            @Validated @RequestBody CustomerRequest request){
        return null;
    }

    @PutMapping()
    public CustomerResponse updateCustomer(
            @Validated @RequestBody CustomerRequest request){
        return null;
    }

    @DeleteMapping("/{customerId}")
    public CustomerRequest deleteCustomer(
            @PathVariable("customerId") String customerId){
        return null;
    }
}
