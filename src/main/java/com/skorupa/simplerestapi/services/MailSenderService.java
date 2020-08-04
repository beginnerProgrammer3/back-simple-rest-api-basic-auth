package com.skorupa.simplerestapi.services;


import com.skorupa.simplerestapi.email.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {

    private JavaMailSender mailSender;
    private MailContentBuilder mailContentBuilder;

    public MailSenderService(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
        this.mailSender = mailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    //    @Autowired
//    private final Configuration template;



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
    public void prepareAndSendByMail(String userEmail ,String verificationtoken) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(userEmail);
            messageHelper.setSubject("Activate Your Email");
            String content = mailContentBuilder.build("http://localhost:8080/verify-email?code=" + verificationtoken);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}

