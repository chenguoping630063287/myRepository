package com.study.messenger.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.messenger.entiry.Employee;
import org.checkerframework.checker.units.qual.K;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 10:22
 * Desc  : 类的作用是 KFK生产者
 **/

@Component
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    private static final String TOPIC = "topic1";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void produce(Object object) throws Exception{


        Employee employee = new Employee();
        BeanUtils.copyProperties(object,employee);
        String value = objectMapper.writeValueAsString(employee);
        log.info("生产者发送消息为：{}",value);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC,value);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TOPIC + "-生产者 发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //发送成功地处理
                log.info(TOPIC + "-生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });

    }
}
