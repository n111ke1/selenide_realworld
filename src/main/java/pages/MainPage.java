package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.cssSelector;


public class MainPage extends BasePage{

    By registrationForm = cssSelector(".navbar-nav .nav-item > a[href='#register']");
    By loginForm = cssSelector(".navbar-nav .nav-item > a[href='#login']");
    By homeTab = cssSelector(".navbar-nav .nav-item > a[href='#']");

    public MainPage checkTittle(){
       Assert.assertEquals(getWebDriver().getTitle(),"Conduit");
        return this;
    }

    public SignInPage clickSignIn() {
        $(loginForm).shouldBe(Condition.visible).click();
        return new SignInPage();
    }

    public SignUpPage clickSignUp() {
       $(registrationForm).shouldBe(Condition.visible).click();
        return new SignUpPage();
    }

    public MainPage clickHome() {
        $(homeTab).shouldBe(Condition.visible).click();
        return new MainPage();
    }





}
