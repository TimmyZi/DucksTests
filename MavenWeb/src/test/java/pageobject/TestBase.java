package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.InternetExplorerFilter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    static WebDriver driver;

    @BeforeTest
    public static void startSettings() {

        Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));
        switch (browser) {
            case chrome -> driver = new ChromeDriver();
            case firefox -> driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public static void openWebsite() {
        driver.get("https://litecart.stqa.ru/");
    }

    @AfterTest
    public static void closeBrowser() {
        driver.quit();
    }
}
