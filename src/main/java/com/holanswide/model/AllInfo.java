package com.holanswide.model;

import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/17
 */
@Repository
public class AllInfo {
    int uid;
    int type;
    String username;
    String code;
    String phone;
    String email;
    String born;
    int sex;

    public AllInfo() {
    }

    public AllInfo(User user, UserInfo userInfo, Rights rights) {
        this.uid=user.getUid();
        this.username=user.getUsername();
        this.born=userInfo.getBorn();
        this.type=rights.getType();
        this.code=rights.getCode();
        this.sex=userInfo.getSex();
        this.phone=userInfo.getPhone();
        this.email=userInfo.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}

