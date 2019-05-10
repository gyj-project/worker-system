package cn.bzu.employeeprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class EmployeeproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeproviderApplication.class, args);
    }

}
