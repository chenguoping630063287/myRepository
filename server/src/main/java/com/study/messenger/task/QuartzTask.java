package com.study.messenger.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 15:44
 * Desc  : 类的作用是什么......
 **/
public class QuartzTask extends QuartzJobBean {

    private static final Logger log= LoggerFactory.getLogger(QuartzTask.class);

    /**
     * 执行定时任务
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("定时任务：{}", LocalDateTime.now().toLocalTime());
    }
}
