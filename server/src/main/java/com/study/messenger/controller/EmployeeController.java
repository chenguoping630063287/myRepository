package com.study.messenger.controller;

import com.study.messenger.entiry.Employee;
import com.study.messenger.response.BaseResponse;
import com.study.messenger.response.StatusCode;
import com.study.messenger.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 13:06
 * Desc  : 类的作用是什么......
 **/

@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private static final String prefix = "/employee";

    @Autowired
    private EmployeeService employeeService;

    private BaseResponse baseResponse = new BaseResponse(StatusCode.SECCESS);

    @RequestMapping(value = prefix + "/detail/{id}",method = RequestMethod.GET)
    public BaseResponse detail(@PathVariable Integer id){
        try{
            Employee employee = employeeService.getEmployee(id);
            baseResponse.setDate(employee);
        }catch (Exception e){
            baseResponse = new BaseResponse(StatusCode.FAIL);
            e.printStackTrace();
        }
        return baseResponse;
    }
}
