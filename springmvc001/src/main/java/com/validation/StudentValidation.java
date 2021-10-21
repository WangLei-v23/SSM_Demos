package com.validation;

import com.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidation implements Validator {

    //判断数据类型是否匹配
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    //进行数据校验
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name",null,"name can not be null!");
        ValidationUtils.rejectIfEmpty(errors,"pwd",null,"pwd can not be null!");

    }
}
