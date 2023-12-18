package com.example.bankservice.notification.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationsenderServiceimpl implements  notificationService{
   private final JavaMailSender mailSender;
   public NotificationsenderServiceimpl(JavaMailSender mailSender){
       this.mailSender = mailSender;
   }
    @Override
    public void sendEmail(String to, String subject, String message){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("adeyemi266@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        this.mailSender.send(simpleMailMessage);
    }
}
