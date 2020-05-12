package org.polele;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-03 09:10
 */
@SpringBootApplication(scanBasePackages = "org.polele")
public class LoginControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginControllerApplication.class, args);
    }
}
