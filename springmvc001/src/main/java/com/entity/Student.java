package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;


import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotEmpty(message = "you! name can not be null !")
    private String name;
    @Size(min = 6,max =12,message = "min length can not less than 6, max length can not less than 12 !")
    private String pwd;
}
