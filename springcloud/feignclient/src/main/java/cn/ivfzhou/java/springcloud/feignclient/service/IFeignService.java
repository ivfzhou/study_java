package cn.ivfzhou.java.springcloud.feignclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import cn.ivfzhou.java.springcloud.feignclient.service.impl.FallbackImpl;

@FeignClient(value = "service", fallback = FallbackImpl.class)
public interface IFeignService {

    @RequestMapping(value = "/get/{params}", method = RequestMethod.POST)
    String run(@PathVariable("params") String params, @RequestBody String body);

}
