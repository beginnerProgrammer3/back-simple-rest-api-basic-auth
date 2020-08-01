package com.skorupa.simplerestapi.services;

import com.skorupa.simplerestapi.repository.UserRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    private JavaMailSender mailSender;
//    private MailContentBuilder mailContentBuilder;

    private UserRepository userRepository;


    public void prepareAndSendByGmail(String userEmail ) {
//        MimeMessagePreparator messagePreparator = mimeMessage -> {
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//            messageHelper.setTo(userEmail);
//            messageHelper.setSubject("Activate Your Email");
////            String content = mailContentBuilder.build(messagesB);
////            messageHelper.setText(content, true);
//        };
//        try {
//            mailSender.send(messagePreparator);
//        } catch (MailException e) {
//            e.printStackTrace();
//        }
//    }
    }}
