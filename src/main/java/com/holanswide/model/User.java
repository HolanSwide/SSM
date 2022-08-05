package com.holanswide.model;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:25
 */

@Repository
public class User {
    @Value(value = "0")
    private int uid;
    @Value(value = "AYANAMI REI")
    private String username;
    @Value(value = "00000000")
    private String password;

    @Override
    public String toString() {
        return "{ " + this.uid + " "
                + this.username + " "
                + this.password + " }";
    }

    public User() {
    }

    public User(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.uid = 0;
        this.username = username;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
