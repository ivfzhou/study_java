package cn.ivfzhou.java.javaee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

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
