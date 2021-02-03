package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBlancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
