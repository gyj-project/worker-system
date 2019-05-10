package cn.bzu.workermanage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@EnableRabbit
public class WorkermanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkermanageApplication.class, args);
    }

}
