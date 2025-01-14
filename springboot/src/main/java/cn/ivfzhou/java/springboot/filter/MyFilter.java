package cn.ivfzhou.java.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void destroy() {
        logger.info("MyFilter destroyed");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        logger.info("MyFilter doFilter before");
        arg2.doFilter(arg0, arg1);
        logger.info("MyFilter doFilter after");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.info("MyFilter initialized");
    }

}
