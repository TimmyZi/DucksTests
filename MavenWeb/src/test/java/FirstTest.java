import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    static WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public static void openWebsite() {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("Open Website");

    }

    @AfterTest
    public static void closeWebsite() {
        driver.quit();
        System.out.println("Close Website");
    }

     @Test
    public static void webSiteLinksTest() throws InterruptedException {
         List<WebElement> elements = driver.findElements(By.tagName("a"));
         elements.get(10).click();
    }
}
