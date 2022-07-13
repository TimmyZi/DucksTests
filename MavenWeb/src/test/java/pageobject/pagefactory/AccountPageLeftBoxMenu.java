package pageobject.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageLeftBoxMenu {

    @FindBy(xpath = "//div[@class = 'content']/ul[@class = 'list-vertical']/li/a[text() = 'Logout']")

    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

}
