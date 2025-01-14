package cn.ivfzhou.java.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    public void init() throws ServletException {
        System.out.println("servlet init " + getInitParameter("servletName"));
    }

}
