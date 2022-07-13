package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.staticpo.*;
import java.util.List;

public class SPOTest extends TestBase {

    @Test
    public static void successfulLoginTest() {
        LoginPage.attemptLogin(driver, "timmyzi@ya.ru", "Test1234!");
        Assert.assertTrue(HomePage.successMessageIsVisible(driver), "Attempt login failed");
    }

    @Test
    public static void unsuccessfulLoginTest() {
        if (HomePage.isUserAuthorized(driver)) {
            AccountPageLeftBoxMenu.clickLogoutButton(driver);
        }

        LoginPage.attemptLogin(driver, "timmyzi@ya.ru", "123");
        Assert.assertTrue(HomePage.unSuccessMessageIsVisible(driver), "Login error not showing");
    }

    @Test
    public static void rubberDucksPriceFilterTest() {
        HeadMenuPage.clickRubberDucksButton(driver);
        FilterPage.clickPriceFilterButton(driver);

        List<WebElement> productPricesSpans = driver.findElements(By.xpath
                ("//ul[@class='listing-wrapper products']//span[@class='price']"));

        List<Double> productPrices = productPricesSpans
                .stream()
                .map(WebElement::getText)
                .map(x -> Double.parseDouble(x.substring(0, x.length() - 2)))
                .toList();

        Assert.assertEquals(productPrices, productPrices.stream().sorted().toList(),
                "Price filter not working properly");
    }

    @Test
    public static void rubberDucksNameFilterTest() {
        HeadMenuPage.clickRubberDucksButton(driver);
        FilterPage.clickNameFilterButton(driver);

        List<WebElement> productNameDivs = driver.findElements(By.xpath
                ("//ul[@class='listing-wrapper products']//div[@class='name']"));

        List<String> names = productNameDivs
                .stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertEquals(names, names.stream().sorted().toList(), "Names filter not working properly");
    }

    @Test
    public static void openChangeSetupWindowTest() {
        HeaderPage.clickChangeButton(driver);

        Assert.assertTrue(RegionalSettingsPage.windowRegionalSettingsIsVisible(driver),
                "Regional settings window isn't open");
    }

    @Test
    public static void openSubcategoryRubberDucksMainMenuTest() {
        HeadMenuPage.clickSubcategoryRubberDucksButton(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='title'][text()='Subcategory']")).isDisplayed(),
                "Subcategory isn't open");
    }

}
