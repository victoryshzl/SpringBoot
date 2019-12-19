package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.bean.User;
import com.example.demo.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by HZL
 * @date 2019/12/17 10:51
 * @description
 */

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserPSRepository userPSRepository;
    @Resource
    private UserJpaRepository userJpaRepository;
    @Resource
    private EmployeeRepository employeeRepository;
    @Resource
    private DepartRepository departRepository;
    @Resource
    private UserJdbcRepository userJdbcRepository;

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }
    public User findById(String id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> findAllSort(Sort sort){
        return userPSRepository.findAll(sort);
    }

    public List<User> getUserByNameLike(String name){
        return userJpaRepository.findByUsernameLike("%"+name+"%");
    }

    public List<Map<String,Object>> getEmployeeByDepartName(String dname){
        List<Employee> es=employeeRepository.findByDepart_departName(dname);
        List<Map<String,Object>> results=new ArrayList<>();
        for (Employee e:es){
            Map<String,Object> m=new HashMap<>();
            m.put("id",e.getId());
            m.put("name",e.getName());
            m.put("age",e.getAge());
            results.add(m);
        }
        return results;
    }

    public Page<User> findAll(Pageable pageable){
        return userPSRepository.findAll(pageable);
    }

    public List<User> getUserByUidBetween(String fuid,String luid){
        return userJpaRepository.findByUidBetween(fuid,luid);
    }

    public List<User> getUserById(String uid){
        return userJpaRepository.findUserByTid(uid);
    }

    /**
     * @description 模糊查询用户的信息
     * @param name
     * @return
     */
    public List<User> getUserByNameLikeSpecification(String name){
        List<User> users=userJpaRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate p1=criteriaBuilder.like(root.get("username"),"%"+name+"%");
                return p1;
            }
        });
        return users;
    }

    /**
     * jdbc查询
     */
    public int insertUser(String uid,String username,String password){
        return userJdbcRepository.insertUser(uid, username, password);
    }
    public User selectUser(String uid){
        return userJdbcRepository.selectUserById(uid);
    }

    public List<User> selectAllUser(){
        return userJdbcRepository.selectAllUser();
    }
}
