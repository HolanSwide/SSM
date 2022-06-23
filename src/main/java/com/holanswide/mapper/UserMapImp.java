package com.holanswide.mapper;

import com.holanswide.model.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:22
 */

public class UserMapImp implements UserMap {
    private SqlSessionTemplate session;
    //必须要有Set方法
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.session = sqlSessionTemplate;
    }

    @Override
    public List<User> queryUserAll() {
        return this.session.getMapper(UserMap.class).queryUserAll();
    }
}
