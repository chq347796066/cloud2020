package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-18 10:43
 */
@RestController
@RequestMapping("/payment")
public class PaymentController
{


    @Value("${server.port}")
    private String serverPort;



    @GetMapping(value = "/create")
    public String create()
    {
       return "cloud-payment-service create,port:"+serverPort;
    }

    @GetMapping(value = "/get")
    public String getPaymentById()
    {
       return "cloud-payment-service get,port:"+serverPort;
    }
}
