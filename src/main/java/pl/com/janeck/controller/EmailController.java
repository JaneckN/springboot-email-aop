package pl.com.janeck.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import pl.com.janeck.service.EmailService;

import java.time.LocalDateTime;

@Service
@Aspect
public class EmailController {


    private MovieController movieController;
    private EmailService emailService;


    public EmailController(MovieController movieController, EmailService emailService) {
        this.movieController = movieController;
        this.emailService = emailService;
    }

    @Before("@annotation(pl.com.janeck.annotation.AddMovie)")
    public void sendEmail() {
        emailService.sendSimpleMessage("janeck@protonmail.com", "Added Movie", "new movie added to DB, @ " + LocalDateTime.now());

    }


}
