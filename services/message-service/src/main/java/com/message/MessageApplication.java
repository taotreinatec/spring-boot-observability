package com.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MessageApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}