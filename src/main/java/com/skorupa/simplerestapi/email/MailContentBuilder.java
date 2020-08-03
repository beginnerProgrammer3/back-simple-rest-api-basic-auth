package com.skorupa.simplerestapi.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


public class MailContentBuilder {
    private TemplateEngine template;


    public MailContentBuilder(TemplateEngine template) {
        this.template = template;
    }

    public String build(String message){
        Context context =  new Context();
        context.setVariable("message",message);

        return template.process("mailTemplate", context);
    }

}
