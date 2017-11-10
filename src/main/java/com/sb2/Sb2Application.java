package com.sb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication
public class Sb2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb2Application.class, args);
    }
}
