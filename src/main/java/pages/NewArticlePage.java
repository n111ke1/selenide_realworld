package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class NewArticlePage extends BasePage {
    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("[type='button']");

    public NewArticlePage inputArticleTitle(String title) {
        $(titleField).shouldBe(Condition.visible).setValue(title);
        return this;
    }

    public NewArticlePage inputWhatArticleAbout(String whatAbout) {
        $(whatAboutField).shouldBe(Condition.visible).setValue(whatAbout);
        return this;
    }

    public NewArticlePage inputArticle(String article) {
        $(articleBodyField).shouldBe(Condition.visible).setValue(article);
        return this;
    }

    public NewArticlePage inputTags(String tags) {
        $(tagsField).shouldBe(Condition.visible).setValue(tags);
        return this;
    }

    public ArticleDetailsPage clickPublishArticleBtn() {
        $(publishArticleBtn).shouldBe(Condition.visible).click();
        return new ArticleDetailsPage();
    }

//    public Article createNewArticle(){
//        Article article = new Article();
//        article.setTitle("TestArticleTitle");
//        article.setDescription("about article");
//        article.setBody("Text text text");
//        article.setTagList(Arrays.asList("tests", "hohho"));
//        return article;
//    }

    public ArticleDetailsPage createNewDefaultPost() {
        inputArticleTitle("TestArticleTitle");
        inputWhatArticleAbout("about article");
        inputArticle("Text text text");
        inputTags("@tags");
        return clickPublishArticleBtn();

    }
}
