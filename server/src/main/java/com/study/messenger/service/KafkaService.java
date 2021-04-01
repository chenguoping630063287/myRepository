package com.study.messenger.service;

import com.study.messenger.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 10:36
 * Desc  : 类的作用是什么......
 **/

@Service
public class KafkaService {

    private static final Logger log = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    public void sendMessage(Object object) throws Exception{
            kafkaProducer.produce(object);
    }
}
