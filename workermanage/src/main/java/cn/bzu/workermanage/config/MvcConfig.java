package cn.bzu.workermanage.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    //视图转换
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*InterceptorRegistration addInterceptor = registry.addInterceptor(new LoginInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/static/**");//排除静态资源
        // 拦截配置
        addInterceptor.addPathPatterns("/**");*/
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/userL
    }
    //访问静态资源
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }






    /* @Bean
    public WebMvcConfigurer indexControllers(){
        WebMvcConfigurer webMvcConfigurer =new WebMvcConfigurer(){
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("success");
            }

        };
        return webMvcConfigurer;
    }*/
}
