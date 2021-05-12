package org.example.teluskosimpebeans;

import org.example.teluskosimpebeans.model.Alien;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringApplication {
    public static void main(String[] args) {
        //org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        ConfigurableApplicationContext context=org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        Alien a1 = context.getBean(Alien.class);       a1.show();
        Alien a2 = context.getBean(Alien.class);       a2.show();
    }
}

