package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    By profileBtn = By.xpath("//*[@class='user-pic']/..");
    By newPostTab = By.cssSelector("[href='#editor']");

    public boolean isUserLoggedIn(String userName) {
      SelenideElement userInfo = $("[href='#@" +userName+"']").shouldBe(Condition.visible);
        return userInfo.isDisplayed();
    }

    public NewArticlePage clickNewPost() {
        $(newPostTab).click();
        return new NewArticlePage();
    }

    public ProfilePage clickProfile() {
        $(profileBtn).click();
        return new ProfilePage();
    }
}
