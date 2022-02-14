package com.learning.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.learning.pojo.User;
import com.learning.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//@Controller
@RestController
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody // 它不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        // jackson
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        User user = new User("gyc_1",20,"男");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("gyc_1", 20, "男");
        User user2 = new User("gyc_2", 20, "男");
        User user3 = new User("gyc_3", 20, "男");
        User user4 = new User("gyc_4", 20, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return JsonUtils.getJson(users);
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("gyc_1", 20, "男");
        User user2 = new User("gyc_2", 20, "男");
        User user3 = new User("gyc_3", 20, "男");
        User user4 = new User("gyc_4", 20, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println("*******Java对象 -> JSON字符串*******");
        String str1 = JSON.toJSONString(users);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 -> Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 -> JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 -> Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "测试fastJSON --结果查看在java后台";

    }

}
