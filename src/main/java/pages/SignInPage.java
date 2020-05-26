package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class SignInPage extends BasePage {

    By errorLoginFields = cssSelector(".error-messages");
    By inputEmailField = By.cssSelector("input[type='email']");
    By inputPassField = By.cssSelector("input[type='password']");
    By signInBtn = By.cssSelector("button[type='submit']");

    public void inputEmail(String email) {
        $(inputEmailField).shouldBe(Condition.visible).setValue(email);
    }

    public void inputPassword(String password) {
       $(inputPassField).shouldBe(Condition.visible).setValue(password);
    }

    public HomePage clickSingInButton() {
        $(signInBtn).shouldBe(Condition.visible).click();
        return new HomePage();
    }

    public String getErrorText(){
     return  $(errorLoginFields).text();
    }

    public HomePage login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        return clickSingInButton();
    }

}
