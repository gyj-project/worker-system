package cn.bzu.employeeprovider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")//将application.yml文件中spring.datasource的属性赋值给下面的bean
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置druid监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //StatViewServlet作用：
        //提供监控信息展示的html页面
        //提供监控信息的JSON API


        //spring boot 默认不支持外部servlet
        //Spring boot 默认为我们提供了注册 Servlet 三大组件 Servlet、Filter、Listener 的接口。我们只需按需配置和添加少量的代码即可实现添加 Servlet 的功能

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParam = new HashMap<>();
        initParam.put("loginUsername", "admin");
        initParam.put("loginPassword", "123456");
        initParam.put("allow", "");
        bean.setInitParameters(initParam);
        return bean;
    }

    //2.配置一个监控的filter
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParam);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
