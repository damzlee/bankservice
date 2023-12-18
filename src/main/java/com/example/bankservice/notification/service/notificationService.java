package com.example.bankservice.notification.service;

public interface notificationService {

    void sendEmail(String to, String subject, String message);
}
