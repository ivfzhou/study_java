package cn.ivfzhou.java.springcloud.service1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/get/{param}")
    @ResponseBody
    public String run(@PathVariable("param") String param) throws InterruptedException {
        System.out.println("MyController.run");
        System.out.println("service20001 sleep 5s");
        Thread.sleep(5000);
        System.out.println("sleep end");
        return param + port;
    }

}
