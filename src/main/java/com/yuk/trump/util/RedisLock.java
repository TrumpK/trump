package com.yuk.trump.util;

import org.springframework.stereotype.Component;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.util.StringUtils;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 18:21
 * @description：RedisLock
 * @modified By：
 */
@Component
public class RedisLock {
    final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public RedisLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * @Description: 加锁
     * @Param: value = 当前时间+超时时间
     * @returns: boolean
     * @Author: zhuenbang
     * @Date: 2018/8/11 10:49
     */
    public boolean lock(String key, String value) {
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {//防止程序错误造成的死锁
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 解锁
     * @Param: [key, value]
     * @returns: void
     * @Author: zhuenbang
     * @Date: 2018/8/11 11:00
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            logger.errorv("【redis分布式锁】解锁异常{}", e.getMessage());
        }
    }
}
