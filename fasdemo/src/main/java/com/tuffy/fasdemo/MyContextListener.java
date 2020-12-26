package com.tuffy.fasdemo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

@Component
public class MyContextListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("===================");
        super.contextInitialized(event);
    }
}
