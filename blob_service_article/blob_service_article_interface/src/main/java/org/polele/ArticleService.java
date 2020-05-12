package org.polele;

import org.polele.pojo.Result;
import org.polele.pojo.article.Article;

public interface ArticleService {

    Result loadArticle(long id);
}
