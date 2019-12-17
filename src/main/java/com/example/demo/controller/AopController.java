package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author by HZL
 * @date 2019/12/16 20:45
 * @description
 */

@Controller
@RequestMapping("/aop")
public class AopController {
    @RequestMapping(value = "/logins")
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "/rget")
    public String doSave(@ModelAttribute Student stu, HttpSession session){
        stu.name=stu.getName().toUpperCase();
        int total=stu.getYw()+stu.getSx()+stu.getYy();
        session.setAttribute("stu",stu);
        session.setAttribute("total",total);
        return "r";
    }
}
