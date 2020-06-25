package browserProfile;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;


public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-extensions");
        options.setCapability("enableVNC", true);
        options.merge(desiredCapabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://selenoid:4444/wd/hub").toURL(), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }



}