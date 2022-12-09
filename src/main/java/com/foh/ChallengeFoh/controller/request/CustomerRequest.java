package com.foh.ChallengeFoh.controller.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String customerId;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
}
