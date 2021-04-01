package com.study.messenger.service;

import com.study.messenger.request.EmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 16:19
 * Desc  : 类的作用是什么......
 **/

@Service
public class SendEmailService {

    private static final Logger log = LoggerFactory.getLogger(SendEmailService.class);

    @Autowired
    private Environment environment;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送文本邮件
     *
     * @param emailRequest
     * @throws Exception
     */
    public void sendEmail(EmailRequest emailRequest) throws Exception{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(environment.getProperty("spring.mail.username"));
        simpleMailMessage.setTo(emailRequest.getMailTos());
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getContent());

        javaMailSender.send(simpleMailMessage);

        log.info("发送文本邮件成功..........................................");
    }
}
