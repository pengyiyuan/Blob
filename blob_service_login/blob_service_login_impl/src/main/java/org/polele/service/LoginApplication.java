package org.polele.service;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 10:17
 */
@SpringBootApplication(scanBasePackages = "org.polele")
@MapperScan(basePackages = {"org.polele.dao"})
@DubboComponentScan(basePackages = {"org.polele.service.login"})
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}
