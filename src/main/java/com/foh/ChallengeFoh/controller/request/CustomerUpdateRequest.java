package com.foh.ChallengeFoh.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerUpdateRequest {
    private String customerId;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
}
