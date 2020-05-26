package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

public class BasePage {

    public String getTextFromElement(SelenideElement element){
        return element.getText();
    }

}
