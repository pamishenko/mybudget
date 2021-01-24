package ru.aboil.myBudget.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
@Slf4j
public class ViewController {

    private final JavaMailSender emailSender;

    @Autowired
    public ViewController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping("/")
    public String openStartPage(){

        System.out.println("тиr");

        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            String htmlMsg = "<!DOCTYPE html>"+
                    "<html lang=\"ru\">"+
                    "<head>"+
                    "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                    "<title>Test Message</title>"+
                    "</head>"+
                    "<body>"+
                    "<p>Тестовое сообщение</p>"+
                    "</body>"+
                    "</html>";

            message.setContent(htmlMsg, "text/html; charset=utf-8");
            helper.setTo("pamishenko@gmail.com");
            helper.setSubject("Тестовое сообщение из Java");
            helper.setFrom("mitch@aboil.ru");

            this.emailSender.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return "start_page";
    }


}
