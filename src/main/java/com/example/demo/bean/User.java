package com.example.demo.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author by HZL
 * @date 2019/12/17 10:46
 * @description
 */

@Entity
@Table(name = "stu")
/**
 * @NamedQuery查询
 */
@NamedQuery(name = "User.findUserByTid",query = "select s from User s where s.uid<?1")
public class User {
    String uid;
    String username;
    String password;

    public User(){}
    @Id
    @GenericGenerator(name = "session_info_uuid_gen",strategy = "assigned")
    @GeneratedValue(generator = "session_info_uuid_gen")
    @Column(name = "uid")

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
