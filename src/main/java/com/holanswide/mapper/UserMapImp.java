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
    public List<User> queryUserAll(int pageBegin, int pageSize) {
        return this.session.getMapper(UserMap.class).queryUserAll(pageBegin, pageSize);
    }

    @Override
    public User queryUserByUsername(String username) {
        return this.session.getMapper(UserMap.class).queryUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        // 检查数据是否非空
        if (user.getUsername() == null || user.getPassword() == null) return 3;
        if (user.getUsername().equals("") || user.getPassword().equals("")) return 3;
        // 检查用户名重复
        if (this.queryUserByUsername(user.getUsername()) != null) return 2;
        return this.session.getMapper(UserMap.class).addUser(user);
    }
}
