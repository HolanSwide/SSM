package com.holanswide.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/17
 */
@Repository
public class Rights {
    int uid;
    String code;
    @Value("3")
    int type;
//    type:
//    0-最高权限，管理全局文件和用户，可以授权管理员
//    1-管理员，管理全局文件和用户
//    2-审核员，管理全局文件
//    3-普通用户

    public Rights(int uid, String code, int type) {
        this.uid = uid;
        this.code = code;
        this.type = type;
    }

    public Rights() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
