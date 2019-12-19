package com.example.demo.repository;

import com.example.demo.bean.Teacher;
import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author by HZL
 * @date 2019/12/17 15:38
 * @description
 */
public interface UserJpaRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
    List<User> findByUsernameLike(String name);

    List<User> findByUidBetween(String fuid,String luid);

    List<User> findUserByTid(String uid);
}
