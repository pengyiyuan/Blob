package org.polele.article;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.polele.ArticleService;
import org.polele.cache.RedisCache;
import org.polele.dao.article.ArticleMapper;
import org.polele.pojo.RedisCachePrefix;
import org.polele.pojo.Result;
import org.polele.pojo.article.Article;
import org.polele.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-12 11:26
 */
@Component
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Result loadArticle(long id) {
        Article article = findArticle(id);
        if (article == null) {
            return ResultUtils.error("文章不存在");
        }
        return ResultUtils.success(JSON.toJSONString(article));
    }

    private Article findArticle(long id) {
        // 先从缓存里查找 article_id
        String redisKey = RedisCachePrefix.ARTICLE_PREFIX + id;
        Article article = redisCache.getObj(redisKey, Article.class);
        // 缓存里读不到要从数据库里读取
        if (article == null) {
            article = articleMapper.findById(id);
            if (article != null) {
                redisCache.setObj(redisKey, article);
            }
        }
        return article;
    }
}
