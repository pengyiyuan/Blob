package org.polele.utils;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-11 22:57
 */
public class UrlUtils {

    /**
     * 根据开始/位置截取中间的字符串
     *
     * @param uri
     * @param start
     * @return
     */
    public static String splitUri(String uri, int start) {
        int sIndex = uri.indexOf("/") + 1;
        int lIndex = uri.indexOf("/", sIndex);
        return uri.substring(sIndex, lIndex);
    }
}
