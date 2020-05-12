package org.polele.pojo.user;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-02 22:55
 */
public class User implements Serializable {

    private Long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String password;
    private Long registerTimeStamp; // 注册时间
    private Long lastLoginTimeStamp; // 上次登录时间

    // TODO 下面两个字段不入库
    private boolean isLogin;// 是否已经登录
    private Map<String, String> tokenMap = new HashMap<>();// 用户用于单点登录sso服务器生成的标识，用来检验是否能登录其他子业务模块，这个不需要入库

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRegisterTimeStamp() {
        return registerTimeStamp;
    }

    public void setRegisterTimeStamp(Long registerTimeStamp) {
        this.registerTimeStamp = registerTimeStamp;
    }

    public Long getLastLoginTimeStamp() {
        return lastLoginTimeStamp;
    }

    public void setLastLoginTimeStamp(Long lastLoginTimeStamp) {
        this.lastLoginTimeStamp = lastLoginTimeStamp;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public Map<String, String> getTokenMap() {
        return tokenMap;
    }

    public void setTokenMap(Map<String, String> tokenMap) {
        this.tokenMap = tokenMap;
    }
}
