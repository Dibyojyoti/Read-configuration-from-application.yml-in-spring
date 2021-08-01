package com.me.spring.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.me.spring.yml")
public class App extends  SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run( Module1App.class, args);
    }
}
