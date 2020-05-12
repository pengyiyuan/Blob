package org.polele.intercepter;

import org.polele.cache.RedisCache;
import org.polele.pojo.RedisCachePrefix;
import org.polele.pojo.user.User;
import org.polele.utils.StringUtils;
import org.polele.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-11 20:42
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String moduleName = UrlUtils.splitUri(request.getRequestURI(), 1);
        if (StringUtils.isBlank(moduleName)) {
            return false;
        } else if (moduleName.equals("user")) {// 代表这是一个登陆模块(其实登陆模块不要扫描这个拦截器即可)
            return true;
        }

        // 如果session中不存在用户数据，说明在当前系统未登录，重定向到sso系统进行登录
        // 如果session还没有数据，那么就要看是否sso重定向过来的请求
        Object attr = request.getSession().getAttribute("userName");
        if (attr == null) {
            String token = request.getParameter("token");
            String userName = request.getParameter("userName");
            if (token == null || userName == null) {
                // TODO 修改地址
                String redirectUrl = "http://localhost:9000/user/loginSub?reqUrl="
                        + request.getRequestURL() + "&moduleName=" + moduleName;
                response.sendRedirect(redirectUrl);
                return false;
            } else { // 验证token
                String redisKey = RedisCachePrefix.USER_PREFIX + userName;
                User user = redisCache.getObj(redisKey, User.class);
                String serverToken = user.getTokenMap().get("article");
                if (!serverToken.equals(token)) {
                    return false;
                }
                // 添加到session中表示用户已经登陆
                request.getSession().setAttribute("userName", userName);
                return true;
            }
        }
        return true;
    }

    private void getModuleFromUri(String reqUri) {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
