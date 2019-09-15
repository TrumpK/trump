package com.yuk.trump.redis;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 18:35
 * @description：KeyPrefix
 * @modified By：
 */
public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}

