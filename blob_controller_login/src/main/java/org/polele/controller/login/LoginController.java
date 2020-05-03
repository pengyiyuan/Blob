package org.polele.controller.login;

import com.alibaba.dubbo.config.annotation.Reference;
import org.polele.pojo.user.User;
import org.polele.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 08:52
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Reference
    private LoginService loginService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return loginService.findAllUser();
    }

    @RequestMapping("/add")
    public void addUser(){
        User user = new User();
        user.setUserName("xiao min");
        user.setPassword("dadadadadada");
        loginService.insertUser(user);
    }

}
