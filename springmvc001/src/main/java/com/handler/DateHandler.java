package com.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/date")
public class DateHandler {

    @RequestMapping("/getDate")
    @ResponseBody
    public String getDate(Date date){
        System.out.println(date);
        return date.toString();
    }
}
