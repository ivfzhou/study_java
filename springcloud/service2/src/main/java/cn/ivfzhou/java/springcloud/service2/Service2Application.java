package cn.ivfzhou.java.springcloud.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Service2Application {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class);
    }

}
