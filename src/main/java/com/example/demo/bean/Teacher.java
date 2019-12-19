package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author by HZL
 * @date 2019/12/17 19:39
 * @description
 */
@Entity
@Table(name = "tb_teacher")
@NamedQuery(name = "Teacher.findTeacherByTid",query = "select s from Teacher s where s.tid<?1")
public class Teacher implements Serializable {
    private static final long serivalVersionUID=1L;
    @Id
    String tid;
    String tname;
    String password;

    public Teacher(){
        super();
    }
    public Teacher(String tid,String tname,String password){
        super();
        this.tid=tid;
        this.tname=tname;
        this.password=password;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
