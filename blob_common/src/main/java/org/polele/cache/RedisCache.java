package org.polele.cache;

import com.alibaba.fastjson.JSON;
import org.polele.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-10 21:03
 */
@Component
public class RedisCache {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setStr(String key, String value) {
        // 默认30分钟有效期
        setStr(key, value, 30, TimeUnit.MINUTES);
    }

    public void setObj(String key, Object value) {
        // 默认30分钟有效期
        setObj(key, value, 30, TimeUnit.MINUTES);
    }

    public void setStrNotExpire(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setObjNotExpire(String key, Object value) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
    }


    public void setStr(String key, String value, long expireTime, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expireTime, unit);
    }

    public void setObj(String key, Object value, long expireTime, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
        redisTemplate.expire(key, expireTime, unit);
    }

    public String getStr(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public <T> T getObj(String key, Class<T> clazz) {
        String json = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return JSON.parseObject(json, clazz);
    }

}
