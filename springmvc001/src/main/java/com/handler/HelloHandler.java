package com.handler;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;

@Controller
@RequestMapping("/index")
public class HelloHandler {

    @RequestMapping("/getPath")
    public String getPath(){
        return "index";
    }

    @RequestMapping("/getIndex")
    public ModelAndView gotoIndex(){
        System.out.println("跳转index页面");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("user1",new User(1,"张三"));
        modelAndView.addObject("user2",new User(1,"李四"));
        modelAndView.addObject("user3",new User(1,"王五"));
        return modelAndView;
    }

    @RequestMapping("/getUser")
    @ResponseBody//返回值不走视图解析器 直接返回
    public User getUSer(HttpServletResponse response){
        //如果要返回User对象，需要手动配置JSON解析器，Spring MVC没有自动转换
        response.setContentType("text/json;charset=UTF-8");//设置响应编码
        User user=new User(1,"张三");
        return user;
    }

    @RequestMapping("/param1")
    public String param1(@RequestBody User user){
        System.out.println(user);
        return "index";
    }


    @RequestMapping("/getDate")
    @ResponseBody
    public String getDate(Date date){
        System.out.println(date);
        return date.toString();
    }

}
