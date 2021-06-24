package com.example.demo.mail;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailService implements MailSender{

    private final static Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(String to, String text) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            helper.setFrom("Rootxw2@gmail.com");
            helper.setTo(to);
            helper.setSubject("confirm your email");
            helper.setText(text, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("email is failed to send");
            throw new IllegalStateException("email is failed to send", e);
        }
    }
}
