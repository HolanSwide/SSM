package com.holanswide.homework.day02;

import com.holanswide.factory.SpringBean;
import com.holanswide.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/2 20:10
 */

@Component
public class JDBCTemplateTest {
    JdbcTemplate template;
    String sql;

    @Test
    public void query() {
        // 查
        template = new JdbcTemplate(SpringBean.getAc().getBean("dataSource", DataSource.class));
        sql = "select * from `user`";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> lu = template.query(sql, rowMapper);
        for (User user : lu) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void Add() {
        // 增
        template = new JdbcTemplate(SpringBean.getAc().getBean("dataSource", DataSource.class));
        sql = "insert into `user`(username,password) values (?,?)";
        template.update(sql, "misato", "123456");
        this.query();
    }

    @Test
    public void del() {
        // 删
        template = new JdbcTemplate(SpringBean.getAc().getBean("dataSource", DataSource.class));
        sql = "delete  from `user` where username=?";
        template.update(sql, "misato");
        this.query();
    }


    @Test
    public void update() {
        // 改
        template = new JdbcTemplate(SpringBean.getAc().getBean("dataSource", DataSource.class));
        sql = "update `user` set password = ? where username = ?";
        template.update(sql, "123456","AyanamiRei");
        this.query();
    }
}
