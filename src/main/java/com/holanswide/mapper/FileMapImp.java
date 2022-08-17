package com.holanswide.mapper;

import com.holanswide.model.FileInfo;
import com.holanswide.utils.SpringBean;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/15
 */
public class FileMapImp implements FileMapper{
    private SqlSessionTemplate session;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.session = sqlSessionTemplate;
    }

    @Override
    public int addFile(FileInfo fileInfo) {
        return this.session.getMapper(FileMapper.class).addFile(fileInfo);
    }

    @Override
    public int delFileByURL(String url) {
        return this.session.getMapper(FileMapper.class).delFileByURL(url);
    }

    @Override
    public List<FileInfo> queryFileInfoByUid(int uid) {
        return this.session.getMapper(FileMapper.class).queryFileInfoByUid(uid);
    }

    @Override
    public List<FileInfo> queryFileInfoAll() {
        return this.session.getMapper(FileMapper.class).queryFileInfoAll();
    }
}
