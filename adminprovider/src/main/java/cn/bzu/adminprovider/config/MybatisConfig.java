package cn.bzu.adminprovider.config;

import com.baomidou.mybatisplus.spring.boot.starter.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        //起用驼峰规则
        return (configuration -> configuration.setMapUnderscoreToCamelCase(true));
    }
}
