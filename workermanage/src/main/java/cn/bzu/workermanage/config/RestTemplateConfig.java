package cn.bzu.workermanage.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class RestTemplateConfig extends WebMvcConfigurationSupport {


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        //默认的MappingJackson2HttpMessageConverter在第7个 先把它移除掉
       // messageConverters.remove(6);
        //添加上GSON的转换器
        //messageConverters.add(7, new GsonHttpMessageConverter());
        return restTemplate;
    }
//









}

