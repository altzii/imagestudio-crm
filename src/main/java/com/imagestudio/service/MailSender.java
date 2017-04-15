package com.imagestudio.service;

import com.google.common.collect.Lists;
import com.imagestudio.model.SignupConfirmation;
import com.imagestudio.model.User;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alt on 15.04.17.
 */
@Component("myMailSender")
public class MailSender {
    @Autowired
    public EmailService emailService;

    public void sendEmailWithoutTemplating() {
        final Email email;
        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("webmaventest@gmail.com", "imagestudio"))
                    .to(Lists.newArrayList(new InternetAddress("sleontjev@yandex.ru")))
                    .subject("Test message from imagestudio")
                    .body("Hello")
                    .encoding("UTF-8").build();

            emailService.send(email);
        } catch (UnsupportedEncodingException | AddressException e) {
            e.printStackTrace();
        }
    }

    public void sendConfirmationEmail(SignupConfirmation signupConfirmation) {
       final Email email;

        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("webmaventest@gmail.com", "imagestudio"))
                    .to(Lists.newArrayList(new InternetAddress(signupConfirmation.getUser().getEmail())))
                    .subject("Регистрация аккаунта на сайте imagestudio")
                    .body("")
                    .encoding("UTF-8").build();

            final Map<String, Object> modelObject = new HashMap<>();
            modelObject.put("code", signupConfirmation.getCode());

            emailService.send(email, "confirmation_email.ftl", modelObject);
        } catch (UnsupportedEncodingException | AddressException | CannotSendEmailException e) {
            e.printStackTrace();
        }

    }

    public void sendCredentialsEmail(User user) {
        final Email email;

        try {
            email = DefaultEmail.builder()
                    .from(new InternetAddress("webmaventest@gmail.com", "imagestudio"))
                    .to(Lists.newArrayList(new InternetAddress(user.getEmail())))
                    .subject("Аккаунт на сайте imagestudio")
                    .body("")
                    .encoding("UTF-8").build();

            final Map<String, Object> modelObject = new HashMap<>();
            modelObject.put("email", user.getEmail());
            modelObject.put("password", user.getPassword());

            emailService.send(email, "credentials_email.ftl", modelObject);
        } catch (UnsupportedEncodingException | AddressException | CannotSendEmailException e) {
            e.printStackTrace();
        }


    }

}
