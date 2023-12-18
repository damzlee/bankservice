package com.example.bankservice.customers.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
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

