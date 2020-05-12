package org.polele.utils;

import org.polele.pojo.Result;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-08 21:38
 */
public class ResultUtils {

    public static Result success() {
        return success("");
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(msg);
        return result;
    }

    public static Result error() {
        return error("");
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(msg);
        return result;
    }

}
