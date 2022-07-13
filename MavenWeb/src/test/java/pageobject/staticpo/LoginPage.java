package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public static void setEmail(WebDriver driver, String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public static void setPassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    public static void attemptLogin(WebDriver driver, String email, String password) {
        setEmail(driver, email);
        setPassword(driver, password);
        clickLoginButton(driver);
    }
}
