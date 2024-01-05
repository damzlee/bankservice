package com.example.bankservice.customers.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerResponse {
    private Long id;
    private String username;
    private Integer password;
    private String firstName;
    private String secondName;
    private String email;
    private String accountNumber;
    private Float Balance;
    private Float Amount;
}
