package cn.ivfzhou.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ivfzhou.java.spring.tx.TX;
import cn.ivfzhou.java.spring.aop.Target;
import cn.ivfzhou.java.spring.bean.User;

public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");

        User user = ac.getBean("user", User.class);
        User user5 = (User) ac.getBean("user5");
        System.out.println(user5 == user);

        Target target = ac.getBean(Target.class);
        target.get();

        User user1 = (User) ac.getBean("user1");
        System.out.println(user1.getSet());

        TX tx = (TX) ac.getBean("tx");
        try {
            tx.insert();
        } catch (Exception ignored) {}
        tx.query();
    }

}
