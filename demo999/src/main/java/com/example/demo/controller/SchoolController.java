package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.SchoolService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @RequestMapping("/user")
    public String to()
    {
        return "index2";
    }
    @RequestMapping("/list")
    @ResponseBody
    public HashMap<Object, Object> findall ()
{



    List<Map> all2 = schoolService.findAll2();



    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("data",all2);
    hashMap.put("code",0);
    hashMap.put("mag","");
    hashMap.put("count",3);
    return hashMap;

/**
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("code",0);
    jsonObject.put("msg","");
    jsonObject.put("count",10);
    jsonObject.put("data", JSONArray.toJSON(all2));
    return jsonObject.toJSONString();
**/



}
@RequestMapping("/user/find")
@ResponseBody
public JSONObject mohu(@RequestParam Integer pageNum)
{
    HashMap<Object, Object> map1 = new HashMap<>();
    map1.put("studentName","沈鼐媛");
    map1.put("address","上海");
    map1.put("love","读书");
    map1.put("course","生物");
    map1.put("teacher","韩硕");
    map1.put("classroom","生物实验室");
    map1.put("age",26);


   for (Map.Entry<Object,Object> entry : map1.entrySet())
   {
       String key= (String) entry.getKey();
       Object value = entry.getValue();
       System.out.println("key:"+key+"value"+value);
       System.out.println(".........");

   }








    List<Map> maps=new ArrayList<>();
    maps.add(map1);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("data", JSON.toJSON(maps));
    jsonObject.put("code",0);
    jsonObject.put("mag","");
    jsonObject.put("count",3);
    PageHelper.startPage(pageNum, 5);
    PageInfo<Map> pageInfo = new PageInfo<>(maps,3);


    return jsonObject;


}
@GetMapping("/login")
public void login(String username,String password)
{
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    try {
        subject.login(token);
        System.out.println("登录成功");
    } catch (AuthenticationException e) {
        System.out.println("登录失败");

    }
}
}
