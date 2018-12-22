package com.lzj.springcloudproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //启动会员服务
public class SpringcloudProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProducerApplication.class, args);
    }
}
