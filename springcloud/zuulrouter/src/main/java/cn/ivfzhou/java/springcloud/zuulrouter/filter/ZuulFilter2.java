package cn.ivfzhou.java.springcloud.zuulrouter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class ZuulFilter2 extends ZuulFilter {

    @Override
    public String filterType() {
        System.out.println("ZuulFilter2.filterType");
        return "pre";
    }

    @Override
    public int filterOrder() {
        System.out.println("ZuulFilter2.filterOrder");
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("ZuulFilter2.shouldFilter");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("ZuulFilter2.run");
        return null;
    }

}
