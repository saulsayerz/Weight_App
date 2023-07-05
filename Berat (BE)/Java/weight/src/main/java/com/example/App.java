package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJpaRepositories("com.example.repository") // Add this line
@ComponentScan(basePackages = { "com.example.*" })
@EntityScan("com.example.model") // Add this line
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

