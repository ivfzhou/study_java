package cn.ivfzhou.java.javaee.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(servletNames = "*", urlPatterns = "/")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init " + filterConfig.getInitParameter("filterName"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter begin");
        chain.doFilter(request, response);
        System.out.println("filter end");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }

}
