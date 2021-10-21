package com.configurations;

import com.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User getUser(){
        return new User(1,"tom",22);
    }
}
