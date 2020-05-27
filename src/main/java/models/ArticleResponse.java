package models;

import lombok.Data;

@Data
public class ArticleResponse {

    private Article article;

    public Article getArticle() {
        return article;
    }
}
