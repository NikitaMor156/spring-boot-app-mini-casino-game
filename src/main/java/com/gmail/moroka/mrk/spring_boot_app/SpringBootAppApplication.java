package com.gmail.moroka.mrk.spring_boot_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAppApplication.class, args);
    }

}
