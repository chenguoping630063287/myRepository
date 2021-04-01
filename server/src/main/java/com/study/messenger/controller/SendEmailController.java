package com.study.messenger.controller;

import com.study.messenger.request.EmailRequest;
import com.study.messenger.response.BaseResponse;
import com.study.messenger.response.StatusCode;
import com.study.messenger.service.SendEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 16:17
 * Desc  : 类的作用是什么......
 **/

@RestController
public class SendEmailController {

    private static final Logger log = LoggerFactory.getLogger(SendEmailController.class);

    private static final String prefix = "/sendEmail";

    @Autowired
    private SendEmailService sendEmailService;

    private BaseResponse baseResponse = new BaseResponse(StatusCode.SECCESS);

    @RequestMapping(value = prefix + "/detail",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse detail(@RequestBody EmailRequest emailRequest){
        log.info("emailRequest : {}" + emailRequest);
        try{
            sendEmailService.sendEmail(emailRequest);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse = new BaseResponse(StatusCode.FAIL);
        }
        return baseResponse;
    }
}
