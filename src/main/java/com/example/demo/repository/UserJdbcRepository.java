package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by HZL
 * @date 2019/12/17 20:28
 * @description
 */

@Repository
public class UserJdbcRepository {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int insertUser(String uid,String username,String password){
        String sql="insert into stu(uid,username,password) values(?,?,?)";
        Object[] args=new Object[]{uid,username,password};
        return jdbcTemplate.update(sql,args);
    }

    public User selectUserById(String uid){
        String sql="select * from stu where uid=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(sql,new Object[]{uid},rowMapper);
    }

    public List<User> selectAllUser(){
        String sql="select * from stu order by uid DESC";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
