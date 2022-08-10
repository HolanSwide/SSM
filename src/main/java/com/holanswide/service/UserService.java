package com.holanswide.service;

import com.holanswide.factory.SpringBean;
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
}
