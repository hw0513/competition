package com.hw.competition.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.hw.competition.core",
        "com.hw.competition.service",
        "com.hw.competition.admin"
        })
public class CompetitionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionAdminApplication.class, args);
        }

}
