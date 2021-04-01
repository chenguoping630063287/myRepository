package com.study.messenger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 12:11
 * Desc  : 类的作用是什么......
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.study.messenger.mapper")
@EnableScheduling   //开启定时任务
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }
}
