package uiTests;

import browserProfile.ChromeDriverProvider;
import browserProfile.FirefoxDriverProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private String baseUrl = "https://react-redux.realworld.io/";
    private static String browserType = System.getProperty("Browser");


    @BeforeMethod
    public MainPage setUp(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true)
                        .savePageSource(true)
                        .enableLogs(LogType.BROWSER, Level.INFO));
        Configuration.browser = ChromeDriverProvider.class.getName();

//        switch (browserType) {
//            case "chrome":
//                Configuration.browser = ChromeDriverProvider.class.getName();
//                break;
//            case "firefox":
//                Configuration.browser = FirefoxDriverProvider.class.getName();
//                break;
//            default:
//                throw new IllegalArgumentException("Incorrect browse type");
//        }

//        Configuration.headless = true;
        Configuration.screenshots = true;
        open("https://react-redux.realworld.io/");
        return new MainPage().checkTittle();
    }


}
