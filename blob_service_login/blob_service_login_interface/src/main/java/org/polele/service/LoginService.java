package org.polele.service;

import org.polele.pojo.user.User;

import java.util.List;

public interface LoginService {

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUser();
}
