package com.mySpringXml.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserDto {
    private String id;
    private String clazz;
    private List<Map<String,String>> properties;
}
