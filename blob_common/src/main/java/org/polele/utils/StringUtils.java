package org.polele.utils;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-08 18:45
 */
public class StringUtils {

    public static Boolean isBlank(String str) {
        return str == null || str.equals("");
    }
}
