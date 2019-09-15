package com.yuk.trump.redis;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 18:37
 * @description：UserKey
 * @modified By：
 */
public class UserKey extends BasePrefix {
    public UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey userAccessKey = new UserKey("access");
}