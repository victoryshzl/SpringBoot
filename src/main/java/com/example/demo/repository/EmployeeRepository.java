package com.example.demo.repository;

import com.example.demo.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author by HZL
 * @date 2019/12/17 16:42
 * @description
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepart_departName(String dname);
    
    @Query("select s from Employee s where s.depart.departName=?1")
    List<Employee> findEmployeesByDepartName(String dname);

}
