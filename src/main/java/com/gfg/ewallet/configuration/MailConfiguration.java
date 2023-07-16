package com.gfg.ewallet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

    @Bean
    public JavaMailSenderImpl getJavaMailSenderImpl(){

        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

        mailSender.setUsername("<email_here>");
        mailSender.setPassword("<password_here>");
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setProtocol("smtp");

        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");

        return mailSender;
    }
}
