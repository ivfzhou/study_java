package cn.ivfzhou.java.springboot;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.ivfzhou.java.springboot.filter.MyFilter;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan("cn.ivfzhou.java.springboot.mapper")
public class SpringBootApplication {

    public static void main(String[] args) throws IOException {
        /*SpringApplication app = new SpringApplication(Application.class);
        Properties properties = new Properties();
        properties.load(Application.class.getClassLoader().getResourceAsStream("application.properties"));
        app.setDefaultProperties(properties);
        app.run(args);*/

        SpringApplication.run(SpringBootApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<MyFilter> init() {
        FilterRegistrationBean<MyFilter> rbean = new FilterRegistrationBean<>();
        rbean.setFilter(new MyFilter());
        rbean.addUrlPatterns("/*");
        rbean.setName("MyFilter");
        return rbean;
    }
}
