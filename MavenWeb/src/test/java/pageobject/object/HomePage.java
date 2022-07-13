package pageobject.object;

import org.openqa.selenium.WebDriver;

import static pageobject.helpers.Locators.getLocator;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean successMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("HomePage.successMessage")).isDisplayed();
    }

    public boolean unSuccessMessageIsVisible() throws Exception {
        return driver.findElement(getLocator("HomePage.unSuccessMessage")).isDisplayed();
    }

    public boolean isUserAuthorized () {
        BottomMenuPage bottomMenuPage = new BottomMenuPage(driver);
        for (int i = 0; i < bottomMenuPage.getAccountMenuItems().size(); i++) {
            if (bottomMenuPage.getAccountMenuItems().get(i).getText().equals("Logout")) {
                return true;
            }
        }
        return false;
    }
}
