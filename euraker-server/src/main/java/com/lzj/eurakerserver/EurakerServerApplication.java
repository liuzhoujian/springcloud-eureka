package com.lzj.eurakerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eurekaServer
public class EurakerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakerServerApplication.class, args);
    }
}
