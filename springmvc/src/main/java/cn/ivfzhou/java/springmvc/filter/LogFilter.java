package cn.ivfzhou.java.springmvc.filter;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
