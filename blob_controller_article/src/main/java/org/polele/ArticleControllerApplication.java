package org.polele;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-11 15:50
 */
@SpringBootApplication(scanBasePackages = "org.polele")
public class ArticleControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleControllerApplication.class, args);
    }
}
