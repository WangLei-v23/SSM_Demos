package com.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class card implements Serializable {
    //开启二级缓存后 实体类需要implement序列化接口 注意关闭第一次查询使用的sqlsession
    private String userCno;
    private String userName;
    private String userGrades;
    private Integer userAge;
}
