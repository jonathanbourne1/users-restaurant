package com.restaurants.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EntityScan({"com.restaurant.commons.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class UsersApplication {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
