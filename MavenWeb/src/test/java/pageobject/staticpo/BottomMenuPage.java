package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BottomMenuPage {

    public static List<WebElement> getAccountMenuItems(WebDriver driver) {
        List<WebElement> accountMenuElements = driver.findElements(By.xpath("//td[@class='account']//a"));
        return accountMenuElements;
    }
}
