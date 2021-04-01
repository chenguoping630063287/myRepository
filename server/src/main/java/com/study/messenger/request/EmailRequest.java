package com.study.messenger.request;

/**
 * Author：chenguoping
 * Date  : 2021/3/27 16:55
 * Desc  : 类的作用是什么......
 **/
public class EmailRequest {

    private String mailTos;
    private String subject;
    private String content;

    public EmailRequest() {
    }

    public EmailRequest(String mailTos, String subject, String content) {
        this.mailTos = mailTos;
        this.subject = subject;
        this.content = content;
    }

    public String getMailTos() {
        return mailTos;
    }

    public void setMailTos(String mailTos) {
        this.mailTos = mailTos;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "mailTos='" + mailTos + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
