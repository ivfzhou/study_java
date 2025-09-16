package cn.ivfzhou.java.nacos.springcloud.controller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/discovery")
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get/{serviceName}")
    @ResponseBody
    public List<ServiceInstance> get(@PathVariable("serviceName") String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

}
