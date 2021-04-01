package com.study.messenger.config;

import com.study.messenger.task.QuartzTask;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 15:46
 * Desc  : 类的作用是什么......
 **/
//@Configuration
public class QuartzConfig {

    private static final Logger log = LoggerFactory.getLogger(QuartzConfig.class);

    //@Bean
    public JobDetail quartzDetail(){
        return JobBuilder.newJob(QuartzTask.class).withIdentity("QuartzTask").storeDurably().build();
    }

    //@Bean
    public Trigger quartzTrigger() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh24:mi:ss");
        String str = "2021-02-28 16:10:00";
        Date date = simpleDateFormat.parse(str);
        //设置时间周期，单位为秒
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(quartzDetail()).withIdentity("QuartzTask").withSchedule(scheduleBuilder).build();
    }
}
