package pageobject;

import pageobject.object.AccountPageLeftBoxMenu;
import pageobject.object.HomePage;
import pageobject.object.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class POTest extends TestBase {

    @Test
    public static void successfulLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("timmyzi@ya.ru", "Test1234!");
        Assert.assertTrue(homePage.successMessageIsVisible(), "Attempt login failed");
    }

    @Test
    public static void unsuccessfulLoginTest() throws Exception {
        AccountPageLeftBoxMenu accountPage = new AccountPageLeftBoxMenu(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        if (homePage.isUserAuthorized()) {
            accountPage.clickLogoutButton();
        }

        loginPage.attemptLogin("timmyzi@ya.ru", "123");
        Assert.assertTrue(homePage.unSuccessMessageIsVisible(), "Login error not showing");
    }
}
