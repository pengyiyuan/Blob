package org.polele.dao.user;

import org.polele.pojo.user.User;

import java.util.List;

public interface UserMapper {

    void insertOne(User user);

    List<User> findAll();

    User findByName(String name);
}
