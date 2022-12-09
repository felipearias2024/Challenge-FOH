package com.foh.ChallengeFoh.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String customerId;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
}
