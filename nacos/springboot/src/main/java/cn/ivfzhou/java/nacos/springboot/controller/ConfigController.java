package cn.ivfzhou.java.nacos.springboot.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private Boolean useLocalCache;

    @RequestMapping(value = "/get")
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

}
