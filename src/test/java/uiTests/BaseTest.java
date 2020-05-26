package uiTests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private String baseUrl = "https://react-redux.realworld.io/";


    @BeforeMethod
    public MainPage setUp(){
//        Configuration.headless = true;
        open(baseUrl);
        return new MainPage().checkTittle();
    }


}
