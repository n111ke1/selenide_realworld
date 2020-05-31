package pages;

import com.codeborne.selenide.Condition;
import models.Article;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class ArticleDetailsPage extends Article {
    By createdPostName = By.cssSelector(".article-page .banner h1");
    By deletePostBtn = By.cssSelector("button.btn-outline-danger");
    By editPostBtn = By.cssSelector(".btn-outline-secondary");

    public String getArticleTitleText(){
        return $(createdPostName).text();
    }

    public HomePage clickDeleteArticle(){
        $(deletePostBtn).shouldBe(Condition.visible).click();
        return new HomePage();
    }

    public NewArticlePage clickEditPost(){
        $(editPostBtn).shouldBe(Condition.visible).click();
        return new NewArticlePage();
    }

}
