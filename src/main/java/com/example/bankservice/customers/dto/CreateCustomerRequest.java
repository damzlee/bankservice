package com.example.bankservice.customers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private String username;
    private Integer password;
    private String firstName;
    private String secondName;
    private String email;
    private Float Amount;
    private Float Balance;
}
