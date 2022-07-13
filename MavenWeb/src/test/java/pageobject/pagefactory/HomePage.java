package pageobject.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "[class='notice success']")
    private WebElement successMessage;

    @FindBy(css = "[class='notice errors']")
    private WebElement unSuccessMessage;


    public boolean successMessageIsVisible() {
        return successMessage.isDisplayed();
    }

    public boolean unSuccessMessageIsVisible() {
        return unSuccessMessage.isDisplayed();
    }
}
