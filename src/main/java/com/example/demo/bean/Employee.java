package com.example.demo.bean;


import javax.persistence.*;

/**
 * @author by HZL
 * @date 2019/12/17 16:25
 * @description
 */

@Entity
@Table(name = "tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Depart.class)
    @JoinColumn(name = "departId",referencedColumnName = "departNo")
    private Depart depart;
    public Employee(){}
    public Employee(String s, int i, Depart d){
        name=s;
        age=i;
        depart=d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }
}
