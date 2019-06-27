package com.example.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages="com.example.springbootjpa")
@EnableJpaRepositories(basePackages = "com.example.springbootjpa")
public class SpringbootJpaApplication {
    public static void main(String[]  args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }
}
