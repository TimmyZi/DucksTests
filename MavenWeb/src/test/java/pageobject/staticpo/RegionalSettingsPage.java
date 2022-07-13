package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegionalSettingsPage {

    public static final By windowRegionalSettings =
            By.xpath("//div[@id='fancybox-content']//div[@id='box-regional-settings']");


    public static boolean windowRegionalSettingsIsVisible (WebDriver driver) {
        return driver.findElement(windowRegionalSettings).isDisplayed();
    }
}
