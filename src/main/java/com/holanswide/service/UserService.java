package com.holanswide.service;

import com.holanswide.utils.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/7 15:52
 */

@Service
public class UserService {
    public List<User> getUsers(String type, String param, int pageSize, int pageBegin) {
        if(type==null && param==null) {
            return SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryUserAll(pageBegin, pageSize);
        }
        return null;
    }
    public int changePwd(String phone, String pwd) {
        int uid = SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryUidByPhone(phone);
        User user = SpringBean.getAc().getBean("userMapImp", UserMapImp.class).queryUserByUid(uid);
        if(user==null) {
            return 0;
            // 手机号不对应
        }
        else {
            user.setPassword(pwd);
            SpringBean.getAc().getBean("userMapImp", UserMapImp.class).updateUser(user);
            return 1;
        }
    }
}
