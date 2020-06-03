package uiTests;

import browserProfile.ChromeDriverProvider;
import browserProfile.FirefoxDriverProvider;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private String baseUrl = "https://react-redux.realworld.io/";
    private static String browserType = System.getProperty("Browser");


    @BeforeMethod
    public MainPage setUp(){

        switch (browserType) {
            case "chrome":
                Configuration.browser = ChromeDriverProvider.class.getName();
                break;
            case "firefox":
                Configuration.browser = FirefoxDriverProvider.class.getName();
                break;
            default:
                throw new IllegalArgumentException("Incorrect browse type");
        }

//        Configuration.headless = true;
        open(baseUrl);
        return new MainPage().checkTittle();
    }


}
