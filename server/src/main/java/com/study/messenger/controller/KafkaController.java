package com.study.messenger.controller;

import com.study.messenger.request.EmployeeDto;
import com.study.messenger.response.BaseResponse;
import com.study.messenger.response.StatusCode;
import com.study.messenger.service.KafkaService;
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
 * Date  : 2021/3/28 10:31
 * Desc  : 类的作用是什么......
 **/

@RestController
public class KafkaController {

    private static final Logger log = LoggerFactory.getLogger(KafkaController.class);

    private static final String prefix = "/kafka";

    @Autowired
    private KafkaService kafkaService;

    BaseResponse baseResponse = new BaseResponse(StatusCode.SECCESS);

    @RequestMapping(value = prefix + "/sendMessage",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse sendMessage(@RequestBody EmployeeDto employeeDto){
        try{
            kafkaService.sendMessage(employeeDto);
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse(StatusCode.FAIL);
        }
        return baseResponse;
    }
}
