package org.polele.service.login;

import com.alibaba.dubbo.config.annotation.Service;
import org.polele.dao.user.UserMapper;
import org.polele.pojo.user.User;
import org.polele.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 10:14
 */
@Component
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertOne(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAll();
    }
}
