package com.gt.app.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * redis工具类，通过spring @Autowired注入使用
 *
 * @author psr
 *         Created by psr on 2017/11/22 0022.
 */
@Repository
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 默认超时时间
     */
    private static final long DEFAULT_TIME = 3;

    /**
     * 设置Redis，默认时间3分钟
     *
     * @param key
     * @param value
     */
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, DEFAULT_TIME, TimeUnit.MINUTES); // 3分钟过期
    }

    /**
     * 设置Redis，使用超时时间，单位秒
     *
     * @param key
     * @param value
     * @param time
     */
    public void setKeySecond(String key, String value, long time) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 设置Redis，使用超时时间，单位小时
     *
     * @param key
     * @param value
     * @param time
     */
    public void setKeyHour(String key, String value, long time) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, time, TimeUnit.HOURS);
    }

    /**
     * 通过key值获取redis值
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

    /**
     * 删除redis值
     *
     * @param key
     */
    public void delValue(String key) {
        template.delete(key);
    }
}
