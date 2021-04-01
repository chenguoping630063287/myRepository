package com.study.messenger.request;

/**
 * Author：chenguoping
 * Date  : 2021/3/28 10:40
 * Desc  : 类的作用是什么......
 **/
public class EmployeeDto {

    private Integer id;

    private String userName;

    private String password;

    private String posName;

    private Integer age;

    private String mobile;

    private String profile;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String userName, String password, String posName, Integer age, String mobile, String profile) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.posName = posName;
        this.age = age;
        this.mobile = mobile;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", posName='" + posName + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
