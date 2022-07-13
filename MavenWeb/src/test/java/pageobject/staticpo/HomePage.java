package pageobject.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static By successMessage = By.cssSelector("[class='notice success']");
    private static By unSuccessMessage = By.cssSelector("[class='notice errors']");

    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(successMessage).isDisplayed();
    }

    public static boolean unSuccessMessageIsVisible(WebDriver driver) {
        return driver.findElement(unSuccessMessage).isDisplayed();
    }

    public static boolean isUserAuthorized (WebDriver driver) {
        BottomMenuPage bottomMenuPage = new BottomMenuPage();
        for (int i = 0; i < bottomMenuPage.getAccountMenuItems(driver).size(); i++) {
            if (bottomMenuPage.getAccountMenuItems(driver).get(i).getText().equals("Logout")) {
                return true;
            }
        }
        return false;
    }
}
