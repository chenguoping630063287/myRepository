package com.study.messenger.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 15:02
 * Desc  : 类的作用是什么......
 **/

/**
 * @Component注解用于对那些比较中立的类进行注解
 * 相当于在持久层、业务层、控制层分别采用的@Repository、@Service、@Controller
 */
@Component
@EnableAsync    //开启多线程
public class MultithreadScheduleTask {

    private static final Logger log = LoggerFactory.getLogger(MultithreadScheduleTask.class);

    @Async
    @Scheduled(cron = "0/1 * * * * ?")   //时间间隔1秒
    public void first() throws Exception{
        log.info("第 1 个定时任务开始：" + LocalDateTime.now().toLocalTime() + "\r\n线程：" + Thread.currentThread().getName());
        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(cron = "0/2 * * * * ?")   //时间间隔2秒
    public void second() throws Exception{
        log.info("第 2 个定时任务开始：" + LocalDateTime.now().toLocalTime() + "\r\n线程：" + Thread.currentThread().getName());
    }
}
