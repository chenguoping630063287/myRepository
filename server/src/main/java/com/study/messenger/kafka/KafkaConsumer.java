package com.study.messenger.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 10:23
 * Desc  : 类的作用是 KFK消费者
 **/

@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"topic1"})
    public void consume(ConsumerRecord record) throws Exception{
        log.info("消费者接收到的数据：{}",record.value());
    }
}
