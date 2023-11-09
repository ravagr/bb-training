package com.backbase.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages = "com.backbase.fee.listener.client.v1.fee.*")
public class Application extends SpringBootServletInitializer {

    //public static final String SIG_SECRET_KEY = "JWTSecretKeyDontUseInProduction!";

    public static void main(final String[] args) {
        //System.out.println(SIG_SECRET_KEY);
        System.out.println(System.getenv("SIG_SECRET_KEY"));
        SpringApplication.run(Application.class, args);
    }

}