package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.lb.LoadBlancer;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController  {
    @Resource
    private RestTemplate restTemplate;
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBlancer loadBlancer;

    @GetMapping("/create")
    public String create(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/create",String.class);
    }

    @GetMapping("/get")
    public String get(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get",String.class);
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instanceList=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBlancer.instance(instanceList);
        String url=instance.getHost()+":"+instance.getPort();
        System.out.println("url:"+url);
        return restTemplate.getForObject(url+"/payment/create",String.class);

    }


}
