package com.bida.finalproject.riaautos.mailsender;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailServiceImpl {


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
        log.info("Massage was sent to" + to + " !");
    }

}
