package com.example.demo.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by HZL
 * @date 2019/12/17 16:26
 * @description
 */

@Entity
@Table(name = "tb_depart")
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departNo;
    private String departName;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = Employee.class,mappedBy = "depart")
    private Set<Employee> employees=new HashSet<>();

    public Depart(){}
    public Depart(String s, Set<Employee> es){
        departName=s;
        employees=es;
    }

    public int getDepartNo() {
        return departNo;
    }

    public void setDepartNo(int departNo) {
        this.departNo = departNo;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
