package com.holanswide.mapper;

import com.holanswide.model.AllInfo;
import com.holanswide.model.Rights;
import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
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
    public List<AllInfo> queryAllInfo() {
        return this.session.getMapper(UserMap.class).queryAllInfo();
    }

    @Override
    public UserInfo queryUserInfoByUid(int uid) {
        return this.session.getMapper(UserMap.class).queryUserInfoByUid(uid);
    }

    @Override
    public List<UserInfo> queryUserInfoAll(int pageBegin, int pageSize) {
        return this.session.getMapper(UserMap.class).queryUserInfoAll(pageBegin, pageSize);
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
    public List<User> queryUserByInfo(String type, String key) {
        return this.session.getMapper(UserMap.class).queryUserByInfo(type, key);
    }

    @Override
    public User queryUserByUid(int uid) {
        return this.session.getMapper(UserMap.class).queryUserByUid(uid);
    }

    @Override
    public int queryUidByPhone(String phone) {
        return this.session.getMapper(UserMap.class).queryUidByPhone(phone);
    }

    @Override
    public List<Integer> queryAllUid() {
        return this.session.getMapper(UserMap.class).queryAllUid();
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

    @Override
    public int addUserInfo(UserInfo userInfo) {
        System.out.println(this.queryUserByInfo("phone",userInfo.getPhone()));
        if(!this.queryUserByInfo("phone",userInfo.getPhone()).isEmpty()) return 4;
        if(!this.queryUserByInfo("email",userInfo.getEmail()).isEmpty()) return 5;
        return this.session.getMapper(UserMap.class).addUserInfo(userInfo);
    }

    @Override
    public void delUserByUid(int uid) {
        if(this.session.getMapper(UserMap.class).queryUserByUid(uid)!=null)
            this.session.getMapper(UserMap.class).delUserByUid(uid);
    }

    @Override
    public void delUserInfoByUid(int uid) {
        this.session.getMapper(UserMap.class).delUserInfoByUid(uid);
    }

    @Override
    public void updateUser(User user) {
        this.session.getMapper(UserMap.class).updateUser(user);
    }

    @Override
    public void updateRights(Rights rights) {
        this.session.getMapper(UserMap.class).updateRights(rights);
    }

    @Override
    public void addRights(Rights rights) {
        this.session.getMapper(UserMap.class).addRights(rights);
    }

    @Override
    public int queryRightByUid(int uid) {
        return this.session.getMapper(UserMap.class).queryRightByUid(uid);
    }

    @Override
    public String queryCodeByUid(int uid) {
        return this.session.getMapper(UserMap.class).queryCodeByUid(uid);
    }
}
