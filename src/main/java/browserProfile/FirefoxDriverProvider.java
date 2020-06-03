package browserProfile;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class FirefoxDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-extensions");
        options.setCapability("enableVNC", true);
        options.merge(desiredCapabilities);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("https://localhost:8080/wd/hub").toURL(), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}