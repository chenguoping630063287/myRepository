package com.study.messenger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.study.messenger.entiry.Employee;
import com.study.messenger.mapper.EmployeeMapper;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 13:06
 * Desc  : 类的作用是什么......
 **/

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Environment environment;

    @Autowired
    private ObjectMapper objectMapper;

    public Employee getEmployee(Integer id) throws Exception{
        log.info("进入方法getEmployee()中.............................");
        Employee employee = null;
        final String key = String.format(environment.getProperty("redis.employee.info.key"),id);
        Integer expire = RandomUtils.nextInt(180,300);
        if(stringRedisTemplate.hasKey(key)){
            String value = stringRedisTemplate.opsForValue().get(key);
            if(!Strings.isNullOrEmpty(value)){
                employee = objectMapper.readValue(value,Employee.class);
            }
        }else {
            employee = employeeMapper.selectByPrimaryKey(id);
            if(employee != null){
                stringRedisTemplate.opsForValue().set(key,objectMapper.writeValueAsString(employee),expire, TimeUnit.SECONDS);
            }else {
                stringRedisTemplate.opsForValue().set(key,"",expire, TimeUnit.SECONDS);
            }
        }
        return employee;
    }
}
