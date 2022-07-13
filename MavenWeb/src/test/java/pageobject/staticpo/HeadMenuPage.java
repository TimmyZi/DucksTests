package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeadMenuPage {

    private static final By homePageButton = By.xpath("//nav[@id='site-menu']//li[@class='general-0']/a");
    private static final By rubberDucksButton = By.xpath("//nav[@id='site-menu']//li[@class='category-1']/a");
    private static final By subcategoryRubberDucksButton =
            By.xpath("//nav[@id='site-menu']//li[@class='category-1']//li[@class='category-2']/a");

    public static void clickHomePageButton(WebDriver driver) {
        driver.findElement(homePageButton).click();
    }
    public static void clickRubberDucksButton(WebDriver driver) {
        driver.findElement(rubberDucksButton).click();
    }
    public static void clickSubcategoryRubberDucksButton(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder.moveToElement(driver.findElement(rubberDucksButton)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(subcategoryRubberDucksButton));
        driver.findElement(subcategoryRubberDucksButton).click();
    }
}
