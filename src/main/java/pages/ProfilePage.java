package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage{
    By articles = By.cssSelector(".article-preview");
    By previewPostName = By.cssSelector(".preview-link h1");

    public String getPreviewArticleText(){
        return $(previewPostName).text();
    }

    public ArticleDetailsPage clickOnArticleTitle(){
        $(".article-preview .preview-link").should(Condition.visible).click();
        return new ArticleDetailsPage();

    }

    public int getArticlesSize() {
        return $$(articles).size();
    }




}
