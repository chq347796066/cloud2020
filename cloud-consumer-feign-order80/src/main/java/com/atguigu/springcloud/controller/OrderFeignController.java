package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.OrderFeignMain;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get")
    public String get(){
        return paymentFeignService.get();
    }

    @GetMapping("/create")
    public String create(){
        return paymentFeignService.create();
    }
}
