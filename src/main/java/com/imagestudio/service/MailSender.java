package com.imagestudio.service;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

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
}
