package com.foh.ChallengeFoh.controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PrimeNamesResponse {
    private Integer primeNamesAmount;
    private List<CustomerResponse> primeNames;
}
