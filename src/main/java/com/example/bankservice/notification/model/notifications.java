package com.example.bankservice.notification.model;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class notifications {
    @Id
    @GeneratedValue
    private Long id;
    private String messageTo;
    private String subject;
    private String message;

}
