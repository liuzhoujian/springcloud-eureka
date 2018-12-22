package com.lzj.springcloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

    @Bean
    //@LoadBalanced 在编写自定义负载均衡时，关闭此注解
    //@LoadBalanced //就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //不加@LoadBalanced 将出现无法解析app-producer地址的错误：java.net.UnknownHostException: app-producer

}
