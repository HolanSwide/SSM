package com.holanswide.test;

import com.holanswide.mapper.FileMapImp;
import com.holanswide.model.FileInfo;
import com.holanswide.utils.SpringBean;
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
        System.out.println(umi.queryUserAll(1,10));
    }
    @Test
    public void StringTest() {
        String s="eva.jpg";
        System.out.println(s.split("\\.")[0]);
    }
    @Test
    public void testFileMapper() {
        SpringBean.getAc().getBean("fileMapImp", FileMapImp.class).addFile(
                SpringBean.getAc().getBean("fileInfo", FileInfo.class)
        );
    }
}
