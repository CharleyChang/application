package com.cliang.application.controller;

import com.cliang.application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CommonController {
    @Autowired
    @Qualifier("ThreadPoolA")
    private ThreadPoolTaskExecutor executorA;



    @RequestMapping("/")
    public String index(){
        return "hello spring boot";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object bathAdd(HttpServletRequest request){
        User user=new User();
        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        System.out.println(user.toString());

        WebAsyncTask<String> task=new WebAsyncTask<String>(10*1000L,executorA,()->{

            return "success" ;
        });

//        task.onCompletion(()->{
//
//        });

        return task;
    }
}
