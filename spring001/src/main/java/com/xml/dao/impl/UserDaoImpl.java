package com.xml.dao.impl;

import com.xml.dao.UserDao;
import com.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
public class UserDaoImpl implements UserDao {
    //临时伪数据
    private static Map<Integer,User> dataMap=null;
    static {
        dataMap=new HashMap<>();
        dataMap.put(1,new User(1,"zhangsan",22));
        dataMap.put(2,new User(2,"lisi",23));
        dataMap.put(3,new User(3,"wangwu",24));
    }

    @Override
    public User getUserById(Integer id) {
        return this.dataMap.get(id);
    }
}
