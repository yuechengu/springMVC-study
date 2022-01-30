package com.learning.controller;

import com.learning.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    // http://localhost:8080/user/t1?name=xxx
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1. 接收前端参数
        System.out.println("接收到的前端参数为："+name);

        //2. 将返回的结果传递给前端，Model
        model.addAttribute("msg",name);

        //3. 视图跳转
        return "testPage";
    }

    // 前端接收的是一个对象: id, name, age
    // http://localhost:8080/user/t2?id=1&name=gyc&age=22
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "testPage";
    }


}
