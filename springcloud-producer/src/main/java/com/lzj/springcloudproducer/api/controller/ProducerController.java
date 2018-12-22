package com.lzj.springcloudproducer.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getMember")
    public String getMember() {
        return "this is a member service" + port;
    }
}
