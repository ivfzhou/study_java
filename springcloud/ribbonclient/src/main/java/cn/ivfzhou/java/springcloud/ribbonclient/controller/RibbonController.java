package cn.ivfzhou.java.springcloud.ribbonclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/ribbon")
    @HystrixCommand(fallbackMethod = "ribbonHystrix")
    public String run() {
        System.out.println("RibbonController.run");
        return rt.getForObject("http://service/get/ribbon", String.class);
    }

    public String ribbonHystrix() {
        return "降级了";
    }

}
