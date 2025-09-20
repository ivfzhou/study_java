package cn.ivfzhou.java.javaee.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.WriteListener;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

@WebFilter(servletNames = "*", urlPatterns = "/")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequestWrapper req = wrapperReq((HttpServletRequest) request);
        ServletResponseWrapper rsp = wrapperRsp((HttpServletResponse) response);
        long now = System.currentTimeMillis();
        chain.doFilter(req, rsp);
        Duration cost = Duration.ofMillis(System.currentTimeMillis() - now);

        if (isEnableLog(request.getContentType())) {
            byte[] reqBody = ((InputStreamDecorator) req.getInputStream()).getReqBody();
            System.out.printf("request body %s\n", new String(reqBody, StandardCharsets.UTF_8));
        }
        if (isEnableLog(rsp.getContentType())) {
            byte[] rspBody = ((OutputStreamDecorator) rsp.getOutputStream()).getRspBody();
            System.out.printf("response body %s\n", new String(rspBody, StandardCharsets.UTF_8));
        }
        System.out.printf("cost %s\n", cost.toString());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private HttpServletResponseWrapper wrapperRsp(HttpServletResponse rsp) throws IOException {
        final OutputStreamDecorator rspDecorator = new OutputStreamDecorator(rsp.getOutputStream());
        return new HttpServletResponseWrapper(rsp) {
            final PrintWriter pw = new PrintWriter(rspDecorator);

            public ServletOutputStream getOutputStream() {
                return rspDecorator;
            }

            public PrintWriter getWriter() {
                return pw;
            }
        };
    }

    private HttpServletRequestWrapper wrapperReq(HttpServletRequest req) throws IOException {
        final InputStreamDecorator reqDecorator = new InputStreamDecorator(req.getInputStream());
        return new HttpServletRequestWrapper(req) {
            public ServletInputStream getInputStream() {
                return reqDecorator;
            }
        };
    }

    private boolean isEnableLog(String ct) {
        if (ct == null || ct.isEmpty())
            return false;
        ct = ct.toLowerCase();
        return ct.contains("application/json") ||
                ct.contains("application/x-www-form-urlencoded") ||
                ct.contains("text/plain");
    }

    private static class OutputStreamDecorator extends ServletOutputStream {
        final ServletOutputStream o;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();

        OutputStreamDecorator(ServletOutputStream o) {
            this.o = o;
        }

        byte[] getRspBody() {
            return bo.toByteArray();
        }

        @Override
        public boolean isReady() {
            return o.isReady();
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            o.setWriteListener(writeListener);
        }

        @Override
        public void write(int b) throws IOException {
            o.write(b);
            bo.write(b);
        }
    }

    private static class InputStreamDecorator extends ServletInputStream {
        final ServletInputStream i;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();

        InputStreamDecorator(ServletInputStream i) {
            this.i = i;
        }

        byte[] getReqBody() {
            return bo.toByteArray();
        }

        @Override
        public boolean isFinished() {
            return i.isFinished();
        }

        @Override
        public boolean isReady() {
            return i.isReady();
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            i.setReadListener(readListener);
        }

        @Override
        public int read() throws IOException {
            int read = i.read();
            bo.write(read);
            return read;
        }
    }

}
