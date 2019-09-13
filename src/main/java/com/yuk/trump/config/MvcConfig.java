package com.yuk.trump.config;

import com.yuk.trump.interceptor.LogInterceptor;
import com.yuk.trump.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 12:51
 * @description：MvcConfig
 * @modified By：
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public LogInterceptor setBean(){
        return new LogInterceptor(); // 注入spring
    }

    /**
     * 静态文件路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 页面拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/manager/**")
                .excludePathPatterns("/static/**","/","/manager/login");
        registry.addInterceptor(setBean()).addPathPatterns("/manager/**")
                .excludePathPatterns("/static/**","/","/manager/login");
    }
}
