package org.polele.login;


import com.alibaba.dubbo.config.annotation.Reference;
import org.polele.LoginService;
import org.polele.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 08:52
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class LoginController {

    private static final String USER_NAME = "user_name";

    @Reference
    private LoginService loginService;

    @ResponseBody
    @RequestMapping("/login")
    public Result login(HttpServletRequest request, String name, String password) {
        Result result = loginService.login(name, password);
        // 成功登陆的时候会在session里面记录用户名
        if (result.isSuccess()) {
            request.getSession().setAttribute(USER_NAME, name);
        }
        return result;
    }

    @RequestMapping("/loginSub")
    public String loginSub(HttpServletRequest request, String moduleName, String reqUrl) {
        Object attr = request.getSession().getAttribute(USER_NAME);
        System.out.println(attr);
        if (attr == null) {
            return null;
        }
        String userName = (String) attr;
        // 生成token
        String token = loginService.loginOther(moduleName, userName);
        // 需要重定向到reqUrl地址
        // TODO 会使参数暴露在url上面
        String redirectUrl = "redirect:" + reqUrl + "?userName=" + userName + "&token=" + token;
        return redirectUrl;
    }

}
