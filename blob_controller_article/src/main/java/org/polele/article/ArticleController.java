package org.polele.article;

import com.alibaba.dubbo.config.annotation.Reference;
import org.polele.ArticleService;
import org.polele.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-11 15:50
 */
@CrossOrigin
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Reference
    private ArticleService articleService;

    @RequestMapping("/loadArticle")
    public Result loadArticle(long articleId) {
        return articleService.loadArticle(articleId);
    }
}
