package cn.ivfzhou.java.nacos.spring;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get/{serviceName}")
    @ResponseBody
    public List<Instance> get(@PathVariable("serviceName") String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

}
