package com.gfg.ewallet.service.impl;

import com.gfg.ewallet.service.NotificationService;
import com.gfg.ewallet.service.resource.NotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    Logger logger= LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void sendNotification(NotificationMessage notificationMessage) {
        try {
            sendEmail(notificationMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            sendSms(notificationMessage);

        }catch (Exception ex){
            
        }
    }

    private void sendSms(NotificationMessage notificationMessage) {
        logger.info("logic to send sms here");
    }

    private void sendEmail(NotificationMessage notificationMessage) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(notificationMessage.getToEmail());
        mailMessage.setSubject(notificationMessage.getSubject());
        mailMessage.setText(notificationMessage.getBody());
        javaMailSender.send(mailMessage);
    }
}
