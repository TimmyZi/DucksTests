package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPageLeftBoxMenu {
    private static By logoutButton =
            By.xpath("//div[@class = 'content']/ul[@class = 'list-vertical']/li/a[text() = 'Logout']");

    public static void clickLogoutButton(WebDriver driver) {
        driver.findElement(logoutButton).click();
    }
}
