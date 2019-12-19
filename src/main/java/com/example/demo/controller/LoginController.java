package com.example.demo.controller;

import com.example.demo.bean.Teacher;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author by HZL
 * @date 2019/12/16 20:45
 * @description
 */

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/logins")
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String doSave(@ModelAttribute User user, HttpSession session){
        user.setUsername(user.getUsername().toUpperCase());
        session.setAttribute("user",user);
        userService.save(user);
        return "r";
    }

    @RequestMapping(value = "/find")
    public String findById(@RequestParam(value = "uid",required = true)String uid,HttpSession session){
        User user=userService.findById(uid);
        session.setAttribute("user",user);
        return "s";
    }

    /**
     * 排序功能
     * @param session
     * @return
     */
//    @RequestMapping(value = "/sorts")
//    public String sortUser(HttpSession session){
//        Sort sort = new Sort(Sort.Direction.DESC,"uid");
//        Iterable<User> UserDatas=userService.findAllSort(sort);
//        session.setAttribute("sort",UserDatas);
//        return "sort";
//    }

    @RequestMapping(value = "/namelike")
    public String getByNameLike(String name,HttpSession session){
        List<User> list=userService.getUserByNameLike(name);
        session.setAttribute("sort",list);
        return "sort";
    }

    @RequestMapping(value = "/getDepartEmployee")
    public String getDepartEmployee(String dname,HttpSession session){
        List<Map<String,Object>> em=userService.getEmployeeByDepartName(dname);
        session.setAttribute("employees",em);
        return "employee";
    }

    /**
     * 分页功能
     */
//    @RequestMapping(value = "/pager")
//    public String sortPageUser(int pageIndex,HttpSession session){
//       Sort sort = new Sort(Sort.Direction.ASC,"uid");
//        Pageable pageable= PageRequest.of(pageIndex-1,3,sort);
//        Page<User> userDatas=userService.findAll(pageable);
//        List<User> users=userDatas.getContent();
//        session.setAttribute("sort",users);
//        return "sort";
//    }

    @RequestMapping(value = "/uidbetween")
    public String getByUidBetween(String begin,String end,HttpSession session){
        List<User> li=userService.getUserByUidBetween(begin,end);
        session.setAttribute("sort",li);
        return "sort";
    }

    @RequestMapping(value = "/getUser")
    public String getUser(String uid,HttpSession session){
        List<User> li=userService.getUserById(uid);
        session.setAttribute("sort",li);
        return "sort";
    }

    @RequestMapping(value = "/getUserSpecification")
    public String getByUidSpecification(String name,HttpSession session){
        List<User> li=userService.getUserByNameLikeSpecification(name);
        session.setAttribute("sort",li);
        return "sort";
    }

    /**
     * jdbc查询
     */
    @RequestMapping(value = "/insertUser")
    public String insertUser(String uid,String username,String password){
        int i=userService.insertUser(uid,username,password);
        return "insert";
    }

    @RequestMapping(value = "/selectUser")
    public String selectUser(String uid,HttpSession session){
        User user=userService.selectUser(uid);
        session.setAttribute("user",user);
        return "s";
    }

    @RequestMapping(value = "/selectAllUser")
    public String selectAllUser(HttpSession session){
        List<User> li=userService.selectAllUser();
        session.setAttribute("sort",li);
        return "sort";
    }

}
