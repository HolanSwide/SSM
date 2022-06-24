package com.holanswide.test;

import com.holanswide.factory.SpringBean;
import com.holanswide.mapper.UserMapImp;
import com.holanswide.model.User;
import org.junit.Test;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:31
 */

public class day01 {
    @Test
    public void testFactorySpringBean() {
        System.out.println(SpringBean.getAc().getBean("user", User.class));
    }
    @Test
    public void MybatisXSpring() {
        UserMapImp umi = (UserMapImp) SpringBean.getAc().getBean("userMapImp",UserMapImp.class);
        System.out.println(umi.queryUserAll());
    }
}
