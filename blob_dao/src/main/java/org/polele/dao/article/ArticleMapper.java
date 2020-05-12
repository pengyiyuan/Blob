package org.polele.dao.article;

import org.polele.pojo.article.Article;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-12 10:44
 */
public interface ArticleMapper {

    Article findById(long articleId);


}
