package com.yuk.trump.config;

import com.yuk.trump.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 11:36
 * @description：日志相关配置
 * @modified By：
 */
@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    /**
     * 用户名
     */
    @Value("${user.home}")
    private String userName;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

    @Bean
    public ApplicationRunner applicationRunner(){
        return applicationArguments -> {

            InetAddress ia = InetAddress.getLocalHost();
            //获取本机内网IP
            LOG.info("启动成功：" + "http://" + ia.getHostAddress() + ":" + port + "/");
            LOG.info("${user.home} ：" + userName);

        };
    }
}
