package com.handler;

import com.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentHandler {

//    @RequestMapping("/login1")
//    @ResponseBody
//    public String login1(@Validated Student student, BindingResult bindingResult, HttpServletResponse response){
//        response.setContentType("text/html;charset=UTF-8");//设置响应编码
//        if (bindingResult.hasErrors()){
//            String msg="";
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError allError : allErrors) {
//                msg+=allError.getDefaultMessage()+"</br>";
//            }
//            return msg;
//        }else{
//            System.out.println(student);
//            return "welcome login!";
//        }
//    }


    @RequestMapping("/login2")
    @ResponseBody
    public String login2(@Valid Student student, BindingResult bindingResult,  HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");//设置响应编码
        if (bindingResult.hasErrors()){
            String msg="";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                msg+=allError.getDefaultMessage()+"</br>";
            }
            return msg;
        }else{
            System.out.println(student);
            return "welcome login!";
        }
    }
}
