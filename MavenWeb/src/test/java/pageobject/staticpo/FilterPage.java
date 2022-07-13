package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPage {

    private static final By nameFilterButton = By.xpath("//nav[@class='filter']/*[text()='Name']");
    private static final By priceFilterButton = By.xpath("//nav[@class='filter']/*[text()='Price']");
    private static final By popularityFilterButton = By.xpath("//nav[@class='filter']/*[text()='Popularity']");
    private static final By dateFilterButton = By.xpath("//nav[@class='filter']/*[text()='Date']");

    public static void clickNameFilterButton(WebDriver driver) {
        driver.findElement(nameFilterButton).click();
    }

    public static void clickPriceFilterButton(WebDriver driver) {
        driver.findElement(priceFilterButton).click();
    }

    public static void clickPopularityFilterButton(WebDriver driver) {
        driver.findElement(popularityFilterButton).click();
    }

    public static void clickDataFilterButton(WebDriver driver) {
        driver.findElement(dateFilterButton).click();
    }
}
