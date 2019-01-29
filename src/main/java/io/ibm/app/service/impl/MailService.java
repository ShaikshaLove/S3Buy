package io.ibm.app.service.impl;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.ibm.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
@Service
public class MailService {

    @Autowired
    private JavaMailSenderImpl sender;
    @Autowired
    private Configuration config;

    public boolean sendEmail(User user,Map<String,Object> model) {
        MimeMessage message = sender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Template temp = config.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(temp, model);

            helper.setText(html, true);
            helper.setTo(user.getEmail());

            helper.setFrom("s3buy@gmail.com");
            helper.setSubject("S3Buy.in");

            helper.addAttachment("logo.png", new ClassPathResource("logo.jpg"));

            helper.setSentDate(new Date());
            sender.send(message);
            return true;

        } catch (IOException | MessagingException | TemplateException e) {
            e.printStackTrace();
            return false;
        }

    }




}
