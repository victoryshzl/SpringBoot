package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author by HZL
 * @date 2019/12/17 11:37
 * @description
 */
public interface UserRepository extends CrudRepository<User,String> {
}
