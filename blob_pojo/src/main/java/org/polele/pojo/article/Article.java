package org.polele.pojo.article;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: PengYiYuan
 * @description:
 * @create: 2020-05-12 10:37
 */
public class Article implements Serializable {

    private Long serialVersionUID = 1L;

    private long articleId;
    private  String title;
    private  String content;
    private String category;
    private Date createTime;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
