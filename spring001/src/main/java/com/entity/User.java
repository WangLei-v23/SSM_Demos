package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor//会覆盖无参构造
@NoArgsConstructor//单独添加无参构造
public class User {
    @Value("1")
    private Integer id;
    @Value("小明")
    private String name;
    @Value("22")
    private Integer age;

}
