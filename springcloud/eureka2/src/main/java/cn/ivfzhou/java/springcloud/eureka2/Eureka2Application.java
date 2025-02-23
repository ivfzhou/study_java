package cn.ivfzhou.java.springcloud.eureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka2Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka2Application.class, args);
    }

}
