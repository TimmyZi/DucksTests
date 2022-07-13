package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BottomMenuPage {

    private final WebDriver driver;

    public BottomMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAccountMenuItems() {
        List<WebElement> accountMenuElements = driver.findElements(By.xpath("//td[@class='account']//a"));
        return accountMenuElements;
    }
}
