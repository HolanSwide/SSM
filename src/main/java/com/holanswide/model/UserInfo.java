package com.holanswide.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/10 16:00
 */
@Repository
public class UserInfo {
    @Value("1")
    int uid;
    @Value("10100000000")
    String phone;
    @Value("test@local.com")
    String email;
    @Value("1")
    int sex;
    @Value("2002-02-29")
    String born;

    @Override
    public String toString() {
        return "{ "+this.uid+
                " "+this.phone+
                " "+this.email+
                " "+this.sex+
                " "+this.born;
    }

    public UserInfo() {
    }

    public UserInfo(int uid, String phone, String email, int sex, String born) {
        this.uid = uid;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.born = born;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
}
