package cn.ivfzhou.java.springmvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@WebFilter(value = "/", servletNames = "*")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var rsp = new ContentCachingResponseWrapper((HttpServletResponse) response);
        req.setCharacterEncoding("UTF-8");
        rsp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, rsp);
        System.out.println("请求体 " + new String(req.getContentAsByteArray()));
        System.out.println("请求结果 " + new String(rsp.getContentAsByteArray()));
        rsp.copyBodyToResponse();
    }

}
