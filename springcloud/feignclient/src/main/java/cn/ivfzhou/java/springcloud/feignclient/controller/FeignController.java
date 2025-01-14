package cn.ivfzhou.java.springcloud.feignclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ivfzhou.java.springcloud.feignclient.service.IFeignService;

@Controller
public class FeignController {

    @Autowired
    private IFeignService iFeignService;

    @RequestMapping("/feign")
    @ResponseBody
    public String run() {
        System.out.println("FeignController.run");
        return iFeignService.run("feign", "hello");
    }

    @RequestMapping("/test_limit")
    @ResponseBody
    public String limit() {
        return "yes";
    }

}
