package com.iflytek.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.iflytek.contoller.UserController;
@WebListener
public class MyListener implements ServletContextListener {
	@Autowired
	private UserController UserController;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println(UserController.helloWorld());
        System.out.println("web项目生成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web项目销毁");
    }
}
