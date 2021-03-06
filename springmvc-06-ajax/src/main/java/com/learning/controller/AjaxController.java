package com.learning.controller;

import com.learning.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if ("gyc".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    @ResponseBody
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();

        //添加数据
        userList.add(new User("Java",1,"男"));
        userList.add(new User("Frontend",1,"女"));
        userList.add(new User("运维",1,"男"));

        return userList;
    }

    @RequestMapping("/a3")
    @ResponseBody
    public String a3(String name, String pwd) {
        String msg="";
        if (name!=null) {
            if ("gyc".equals(name)) {
                msg="ok";
            }else {
                msg="用户名错误";
            }
        }
        if (pwd!=null) {
            if ("123456".equals(pwd)) {
                msg="ok";
            }else {
                msg="密码错误";
            }
        }
        return msg;
    }

}
