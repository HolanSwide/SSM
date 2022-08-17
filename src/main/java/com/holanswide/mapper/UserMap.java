package com.holanswide.mapper;

import com.holanswide.model.AllInfo;
import com.holanswide.model.Rights;
import com.holanswide.model.User;
import com.holanswide.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMap {
    public List<AllInfo> queryAllInfo();
    public UserInfo queryUserInfoByUid(int uid);
    public List<UserInfo> queryUserInfoAll(@Param("pageBegin") int pageBegin, @Param("pageSize") int pageSize);
    public List<User> queryUserAll(@Param("pageBegin") int pageBegin, @Param("pageSize") int pageSize);
    public User queryUserByUsername(@Param("username") String username);
    public List<User> queryUserByInfo(@Param("type") String type, @Param("key") String key);
    public User queryUserByUid(@Param("uid") int uid);
    public int queryUidByPhone(@Param("phone") String phone);
    public List<Integer> queryAllUid();

    public int addUser(User user);
    public int addUserInfo(UserInfo userInfo);

    public void delUserByUid(@Param("uid") int uid);
    public void delUserInfoByUid(@Param("uid") int uid);

    public void updateUser(User user);

    public void updateRights(Rights rights);
    public void addRights(Rights rights);
    public int queryRightByUid(int uid);
    public String queryCodeByUid(int uid);
}
