package com.cliang.application.controller;

import com.cliang.application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    @Qualifier("ThreadPoolA")
    private ThreadPoolTaskExecutor executorA;

    @RequestMapping("/")
    public String index(){
        return "hello spring boot";
    }

    @RequestMapping("/add")
    public Object bathAdd(@RequestBody User user){

        return null;
    }
}
