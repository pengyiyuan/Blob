package org.polele;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-12 11:21
 */
@SpringBootApplication(scanBasePackages = "org.polele")
@MapperScan(basePackages = {"org.polele.dao"})
@DubboComponentScan(basePackages = {"org.polele.article"})
public class ArticleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }
}
