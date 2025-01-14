package cn.ivfzhou.java.spring;

import cn.ivfzhou.java.spring.bean.User;
import cn.ivfzhou.java.spring.tx.TX;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:application.xml")
public class SpringApplicationTest {

    @Autowired
    @Qualifier("user")
    User user;

    @Autowired
    TX tx;

    @BeforeAll
    public static void setup() {
        System.out.println("setup");
    }

    @AfterAll
    public static void teardown() {
        System.out.println("teardown");
    }

    @BeforeEach
    public void before() {
        System.out.println("before");
    }

    @AfterEach
    public void after() {
        System.out.println("after");
    }

    @Test
    public void test() {
        System.out.println(user);
    }

    @Test
    public void query() {
        tx.query();
    }

    @Test
    public void insert() {
        try {
            tx.insert();
        } catch (Exception e) {
            System.out.println("回滚了");
        }
    }

}
