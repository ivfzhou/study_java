package cn.ivfzhou.java.springcloud.feignclient.service.impl;

import cn.ivfzhou.java.springcloud.feignclient.service.IFeignService;
import org.springframework.stereotype.Component;

@Component
public class FallbackImpl implements IFeignService {

    @Override
    public String run(String params, String body) {
        return "降级了";
    }

}
