package pageobject.object;

import org.openqa.selenium.WebDriver;

import static pageobject.helpers.Locators.getLocator;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) throws Exception {
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
    }

    public void setPassword(String password) throws Exception {
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public void clickLoginButton() throws Exception {
        driver.findElement(getLocator("LoginPage.loginButton")).click();
    }

    public void attemptLogin(String email, String password) throws Exception {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
