package com.example.bankservice.notification.model;


import com.example.bankservice.customers.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class notification {
@Id
    private String to;
    private String subject;
    private String message;

}
