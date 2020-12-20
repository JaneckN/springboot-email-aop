package pl.com.janeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.com.janeck.configuration.EmailConfiguration;

@Component
public class MailService {


    private EmailConfiguration emailConfiguration;


    @Autowired
    public MailService(EmailConfiguration emailConfiguration) {
        this.emailConfiguration = emailConfiguration;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailConfiguration.getJavaMailSender().send(message);
    }


}