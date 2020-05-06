package org.polele.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-06 10:28
 */
@Component
public class RedisCache {

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setStr(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getStr(String key) {
       return (String) redisTemplate.opsForValue().get(key);
    }
}
