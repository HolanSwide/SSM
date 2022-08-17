package com.holanswide.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/15
 */
@Repository
public class FileInfo {
    @Value("0")
    int fid;
    @Value("#")
    String url;
    @Value("1")
    int uid;
    @Value("test")
    String filename;
    @Value("这个人很懒，什么都没写...")
    String describe;
    @Value(".")
    String type;
    @Value("unknown")
    String memory;

    public FileInfo() {
    }

    public FileInfo(int fid, String url, int uid, String filename, String describe, String type, String memory) {
        this.url = url;
        this.uid = uid;
        this.filename = filename;
        this.describe = describe;
        this.type = type;
        this.memory = memory;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
