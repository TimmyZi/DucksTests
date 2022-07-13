package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    public static final By changeButton =
            By.xpath("//header[@id='header']/div[@id='region-wrapper']//div[@class = 'change']/a");

    public static void clickChangeButton(WebDriver driver) {
        driver.findElement(changeButton).click();
    }
}
