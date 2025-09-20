package cn.ivfzhou.java.javaee.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("hello doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        StringBuffer sb = new StringBuffer();
        byte[] bs = new byte[8 * 1024];
        for (int len = inputStream.read(bs); len != -1; len = inputStream.read(bs)) {
            sb.append(new String(bs, 0, len, StandardCharsets.UTF_8));
        }
        inputStream.close();
        System.out.println(sb);

        resp.addHeader("Content-Type", "text/plain");
        resp.getOutputStream().println("hello doPost");
    }

    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }

    @Override
    public void init() {
        System.out.println("servlet init " + getInitParameter("servletName"));
    }

}
