package com.learning.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注意：这里我们先导入Controller接口
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        // 业务代码封装
        mv.addObject("msg","HelloSpringMVC!");

        // 视图跳转
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp

        return mv;
    }
}