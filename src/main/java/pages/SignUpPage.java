package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class SignUpPage extends BasePage {
    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By inputEmailField = cssSelector("input[type='email']");
    By inputPasswordField = cssSelector("input[type='password']");
    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By usernameField = cssSelector("input[type='text']");
    By submitFormBtn = cssSelector("button[type='submit']");
    By errorEmail = cssSelector(".error-messages li:nth-child(1)");
    By errorPass = cssSelector(".error-messages li:nth-child(2)");
    By errorUser = cssSelector(".error-messages li:nth-child(3)");

    public SignUpPage inputEmail(String email) {
       $(inputEmailField).shouldBe(Condition.visible).setValue(email);
        return this;
    }

    public SignUpPage inputPassword(String password) {
       $(inputPasswordField).shouldBe(Condition.visible).setValue(password);
        return this;
    }

    public SignUpPage inputUserName(String username) {
      $(usernameField).shouldBe(Condition.visible).setValue(username);
        return this;
    }

    public HomePage clickSignInBtn(){
      $(submitFormBtn).click();
        return new HomePage();
    }

    public String getErrorUserNameText(){
        return $(errorUser).text();
    }

    public String getErrorEmailText(){
        return $(errorEmail).text();
    }

    public String getErrorPassText(){
        return $(errorPass).text();
    }


}
