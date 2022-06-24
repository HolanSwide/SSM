package com.holanswide.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/6/23 23:33
 */

public class SpringBean {
    static String url = "spring-config.xml";
    static ApplicationContext ac = new ClassPathXmlApplicationContext(url);

    public static ApplicationContext getAc() {
        return ac;
    }
}
