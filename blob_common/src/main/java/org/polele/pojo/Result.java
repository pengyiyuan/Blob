package org.polele.pojo;

import java.io.Serializable;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-08 21:42
 */
public class Result implements Serializable {

    private boolean success;
    private String message;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
