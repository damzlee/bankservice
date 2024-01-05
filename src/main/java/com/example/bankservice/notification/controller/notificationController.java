package com.example.bankservice.notification.controller;

import org.springframework.http.ResponseEntity;
import com.example.bankservice.notification.service.notificationService;
import com.example.bankservice.notification.model.notifications;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/notification/")
public class notificationController {

 private final notificationService notificationService;

    public notificationController(notificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity sendMail(@RequestBody notifications notification){
this.notificationService.sendEmail(notification.getMessageTo(), notification.getSubject(), notification.getMessage());
return ResponseEntity.ok("sucess");
    }
}
