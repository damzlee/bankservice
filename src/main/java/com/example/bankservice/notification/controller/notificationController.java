package com.example.bankservice.notification.controller;

import com.example.bankservice.customers.model.Customer;
import org.springframework.http.ResponseEntity;
import com.example.bankservice.notification.service.notificationService;
import com.example.bankservice.notification.model.notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Notification;

@RestController
public class notificationController {

 private final notificationService notificationService;

    public notificationController(notificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity sendMail(@RequestBody notification notification){
this.notificationService.sendEmail(notification.getTo(), notification.getSubject(), notification.getMessage());
return ResponseEntity.ok("sucess");
    }
}
