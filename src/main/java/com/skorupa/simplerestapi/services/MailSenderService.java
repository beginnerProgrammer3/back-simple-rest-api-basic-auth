package com.skorupa.simplerestapi.services;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailSenderService {

//    private final JavaMailSender mailSender;
//    private final Configuration template;
//
//    public MailSenderService(JavaMailSender mailSender, Configuration template) {
//        this.mailSender = mailSender;
//        this.template = template;
//    }
//
//    public boolean sendVerificationMail(String useremail, String verifyCode){
//        String subject = "Please verify yourmail";
//        String body = "";
//
//        try{
//            Template temp = template.getTemplate("verify-email.ftl");
//            Map<String,String> map = new HashMap<>();
//            map.put("VERIFICATION_URL", mail)
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (MalformedTemplateNameException e) {
//            e.printStackTrace();
//        } catch (TemplateNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void prepareAndSendByGmail(String userEmail ) {
////        MimeMessagePreparator messagePreparator = mimeMessage -> {
////            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
////            messageHelper.setTo(userEmail);
////            messageHelper.setSubject("Activate Your Email");
//////            String content = mailContentBuilder.build(messagesB);
//////            messageHelper.setText(content, true);
////        };
////        try {
////            mailSender.send(messagePreparator);
////        } catch (MailException e) {
////            e.printStackTrace();
////        }
////    }
//    }
}
