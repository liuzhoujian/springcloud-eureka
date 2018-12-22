package com.lzj.springcloudconsumer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义实现客户端负载均衡
 */
@RestController
public class ExtRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //初始化请求数
    private AtomicInteger requestCnt = new AtomicInteger(1);

    @RequestMapping("/ribbon")
    public String ribbon() {
        //1、选取一个服务地址
        String serviceUrl = getServiceUrl() + "/getMember";
        //2、远程调用
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    //本地负载均衡核心代码
    private String getServiceUrl() {
        //在注册中心获取app-producer对应的服务列表
        List<ServiceInstance> list = discoveryClient.getInstances("app-producer");
        if(list == null && list.size() == 0) {
            return null;
        }

        //获取服务列表的数量
        int serviceSize = list.size();
        //请求数 % 服务列表数量 得到下标
        int index = requestCnt.get() % serviceSize;
        //将请求数增加1
        requestCnt.incrementAndGet();
        //根据计算的下标选取一个服务地址返回
        return list.get(index).getUri().toString();
    }
}
