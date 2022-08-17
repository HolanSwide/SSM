package com.holanswide.mapper;

import com.holanswide.model.FileInfo;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/15
 */
public interface FileMapper {
    public int addFile(FileInfo fileInfo);
    public int delFileByURL(String url);
    public List<FileInfo> queryFileInfoByUid(int uid);
    public List<FileInfo> queryFileInfoAll();
}
