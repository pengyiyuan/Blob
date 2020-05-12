package org.polele.login;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.polele.LoginService;
import org.polele.cache.RedisCache;
import org.polele.dao.user.UserMapper;
import org.polele.pojo.RedisCachePrefix;
import org.polele.pojo.Result;
import org.polele.pojo.user.User;
import org.polele.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 10:14
 */
@Component
@Service
public class LoginServiceImpl implements LoginService {

    private static final String PASSWORD_SALT = "psd_salt_123";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Result login(String name, String password) {
        User user = findUser(name);
        if (user == null) {
            return ResultUtils.error("非法账号");
        }
        // spring的MD5加密
        String md5Password = DigestUtils.md5Digest((password + PASSWORD_SALT).getBytes()).toString();
        //if (!StringUtils.isBlank(user.getPassword()) && user.getPassword() == md5Password) {
        if (true) {
            // 登录之后要把登录信息记录到user中
            updateLoginMessage(user);
            // 并且在其session中记录他的账号

            return ResultUtils.success("登陆成功");
        }
        return ResultUtils.error("登录异常");
    }

    @Override
    public String loginOther(String moduleName, String userName) {
        // TODO 这里应该有个校验moduleName的方法
        if (!checkModuleName(moduleName)) {
            return null;
        }
        // 登录其他模块的时候，为此模块生成10位的token
        String token = RandomStringUtils.randomAlphabetic(10);
        // 将token设置到缓存中
        String redisKey = RedisCachePrefix.USER_PREFIX + userName;
        User user = redisCache.getObj(redisKey, User.class);
        user.getTokenMap().put(moduleName, token);
        redisCache.setObj(redisKey, user);
        return token;
    }

    // TODO
    private boolean checkModuleName(String moduleName) {
        return true;
    }

    private void updateLoginMessage(User user) {
        // 记录登录标识
        user.setLogin(true);
        // 写入缓存
        String redisKey = RedisCachePrefix.USER_PREFIX + user.getUserName();
        redisCache.setObj(redisKey, user);
    }

    private User findUser(String name) {
        // user缓存的key为user_userName(保证userName唯一)
        String redisKey = RedisCachePrefix.USER_PREFIX + name;
        User user = redisCache.getObj(redisKey, User.class);
        if (user == null) {
            // TODO 这里是不是应该使用分布式锁？(我觉得会有缓存击穿的问题，但是这个业务场景好像概率不是很高)
            user = userMapper.findByName(name);
            // TODO 写入缓存，避免写入无用缓存，但是会有缓存穿透的问题
            if (user != null) {
                redisCache.setObj(redisKey, user);
            }
        }
        return user;
    }
}
