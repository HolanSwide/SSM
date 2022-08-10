package com.holanswide.mapper;

import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMap {
    public List<User> queryUserAll(@Param("pageBegin") int pageBegin, @Param("pageSize") int pageSize);
    public User queryUserByUsername(@Param("username") String username);
    public List<User> queryUserByInfo(@Param("type") String type, @Param("key") String key);

    public int addUser(User user);
    public int addUserInfo(UserInfo userInfo);
}
