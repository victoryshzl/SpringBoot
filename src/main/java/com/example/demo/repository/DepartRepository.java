package com.example.demo.repository;

import com.example.demo.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by HZL
 * @date 2019/12/17 16:42
 * @description
 */
public interface DepartRepository extends JpaRepository<Depart,Integer> {
}
