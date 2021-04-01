package com.study.messenger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 19:51
 * Desc  : 类的作用是什么......
 **/

@RestController
public class IOController {

    private static final Logger log = LoggerFactory.getLogger(IOController.class);

    private static final String prefix = "IO";

    @RequestMapping(value = prefix + "/detailIO")
    public void detailIO(){
        String str = "hello word!";
        byte[] byteArray = str.getBytes();
        File file = new File("E:/IO/text.txt");
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            outputStream.write(byteArray);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
