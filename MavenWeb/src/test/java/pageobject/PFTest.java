package pageobject;

import org.openqa.selenium.support.PageFactory;
import pageobject.pagefactory.AccountPageLeftBoxMenu;
import pageobject.pagefactory.BottomMenuPage;
import pageobject.pagefactory.HomePage;
import pageobject.pagefactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PFTest extends TestBase {

    @Test
    public static void successfulLoginTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.attemptLogin("timmyzi@ya.ru", "Test1234!");
        Assert.assertTrue(homePage.successMessageIsVisible(), "Attempt login failed");
    }

    @Test
    public static void unsuccessfulLoginTest() {
        AccountPageLeftBoxMenu accountPage = PageFactory.initElements(driver, AccountPageLeftBoxMenu.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        BottomMenuPage bottomMenuPage = PageFactory.initElements(driver, BottomMenuPage.class);

        if (bottomMenuPage.isUserAuthorized()) {
            accountPage.clickLogoutButton();
        }

        loginPage.attemptLogin("timmyzi@ya.ru", "123");
        Assert.assertTrue(homePage.unSuccessMessageIsVisible(), "Login error not showing");
    }
}
