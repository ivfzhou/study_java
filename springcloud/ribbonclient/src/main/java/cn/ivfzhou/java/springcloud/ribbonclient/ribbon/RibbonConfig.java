package cn.ivfzhou.java.springcloud.ribbonclient.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

//@Configurable
//@ExcludeComponent
public class RibbonConfig {

    //@Bean
    public IRule getRule() {
        return new RoundRobinRule();
    }

}
