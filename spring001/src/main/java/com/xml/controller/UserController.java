package com.xml.controller;

import com.xml.service.UserService;
import com.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Data
//@Component//顶级注解 任何bean都可以用
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public User getUserById(Integer id){
        return userService.getUserById(id);
    }
}
