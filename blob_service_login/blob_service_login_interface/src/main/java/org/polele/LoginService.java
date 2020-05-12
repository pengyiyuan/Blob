package org.polele;

import org.polele.pojo.Result;
import org.polele.pojo.user.User;

import java.util.List;

public interface LoginService {

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    Result login(String name, String password);

    /**
     * 登录其他模块
     *
     * @param moduleName
     * @param userName
     * @return 返回token
     */
    String loginOther(String moduleName, String userName);
}
