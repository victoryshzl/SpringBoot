package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author by HZL
 * @date 2019/12/17 14:31
 * @description
 */
public interface UserPSRepository extends PagingAndSortingRepository<User,String> {

}
