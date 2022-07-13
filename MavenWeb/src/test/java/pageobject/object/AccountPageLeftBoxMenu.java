package pageobject.object;

import org.openqa.selenium.WebDriver;

import static pageobject.helpers.Locators.getLocator;

public class AccountPageLeftBoxMenu {

    private final WebDriver driver;

    public AccountPageLeftBoxMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() throws Exception {
        driver.findElement(getLocator("AccountPageLeftBoxMenu.logoutButton")).click();
    }

}
