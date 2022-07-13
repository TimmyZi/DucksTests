package pageobject.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BottomMenuPage {

    @FindBy(xpath = "//td[@class='account']//a")
    private static List<WebElement> accountMenuItems;

    public boolean isUserAuthorized () {
        for (WebElement accountMenuItem : accountMenuItems) {
            if (accountMenuItem.getText().equals("Logout")) {
                return true;
            }
        }
        return false;
    }

}
