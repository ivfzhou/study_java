package cn.ivfzhou.java.springcloud.zuulrouter.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {

    @Override
    public String filterType() {
        System.out.println("ZuulFilter.filterType");
        return "pre"; // pre -> routing -> post -> error
    }

    @Override
    public int filterOrder() {
        System.out.println("ZuulFilter.filterOrder");
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("ZuulFilter.shouldFilter");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("ZuulFilter.run");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        // 是否拦截。
        ctx.setSendZuulResponse(true);
        return null;
    }

}
