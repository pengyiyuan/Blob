package org.polele.pojo.user;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-02 22:55
 */
public class User implements Serializable {

    private Long userId;
    private String userName;
    private String password;
    private Long registerTimeStamp;
    private Long lastLoginTimeStamp;

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
}
