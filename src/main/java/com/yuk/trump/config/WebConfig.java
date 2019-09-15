package com.yuk.trump.config;

import com.yuk.trump.filter.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/15 10:52
 * @description：
 * @modified By：
 */
@Service
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor);
    }
}
