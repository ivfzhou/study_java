package cn.ivfzhou.java.shiro.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.env.BasicIniEnvironment;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class Common {

    public static void main(String[] args) {
        BasicIniEnvironment environment = new BasicIniEnvironment("classpath:shiro.ini");
        SecurityManager securityManager = environment.getSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("passwd", "123456");

        if ("123456".equals(session.getAttribute("passwd"))) {
            System.out.println("OK");
        }

        if (!subject.isAuthenticated()) {
            UsernamePasswordToken ivfzhou = new UsernamePasswordToken("ivfzhou", "123456");
            ivfzhou.setRememberMe(true);
            try {
                subject.login(ivfzhou);
                System.out.println("login");
            } catch (UnknownAccountException e) {
                System.out.println("UnknownAccountException" + e);
            } catch (IncorrectCredentialsException e) {
                System.out.println("IncorrectCredentialsException" + e);
            } catch (LockedAccountException e) {
                System.out.println("LockedAccountException" + e);
            }
        }
        System.out.println(subject.getPrincipal());

        System.out.println("hasRole admin " + subject.hasRole("admin"));
        System.out.println("isPermitted " + subject.isPermitted("query:data:all"));

        subject.logout();

    }

}
