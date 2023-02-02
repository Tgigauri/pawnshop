package com.shop.pawnshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PawnshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PawnshopApplication.class, args);
    }

}
