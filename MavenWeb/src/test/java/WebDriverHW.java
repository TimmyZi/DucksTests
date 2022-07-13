import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class WebDriverHW {

    static WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public static void openWebsite() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        System.out.println("Open Website");
    }

    @AfterMethod
    public static void afterTestMessage() {
        System.out.println("Test end");
    }

    @AfterTest
    public static void closeBrowser() {
        driver.quit();
        System.out.println("Close Browser");
    }

    @Test
    public static void openRubberDucks() {
        WebElement rubberDucks = driver.findElement(By.xpath("//div[@id='page-wrapper']" +
                "//div[@id='site-menu-wrapper']//ul/li[@class='category-1']/a"));
        rubberDucks.click();

        driver.findElement(By.xpath("//h1[@class='title']|//div[@id='site-menu-wrapper']"));
        driver.findElement(By.xpath("//h1[text()='Rubber Ducks']"));

        System.out.println("Open Rubber Ducks");
    }

    @Test
    public static void openDeliveryInformation() {
        WebElement deliveryInformation = driver.findElement(By.xpath("//body//div[@id='page-wrapper']" +
                "//div[@id='site-menu-wrapper']//li[@class='page-2']/a"));
        deliveryInformation.click();

        driver.findElement(By.xpath("//h1//font/u[text()='информация о доставке']"));

        System.out.println("Open Delivery Information");
    }

    @Test
    public static void openTermConditions() {
        WebElement termConditions = driver.findElement(By.xpath("//body//div[@id='page-wrapper']" +
                "//div[@id='site-menu-wrapper']//ul/li[@class='page-4']/a"));
        termConditions.click();
        driver.findElement(By.xpath("//h1//font[@style]//u[text()='Условия']"));

        System.out.println("Open Term & Conditions");
    }

    @Test
    public static void openSalesStocks() {
        WebElement SalesStocks = driver.findElement(By.xpath("//body//div[@id='site-menu-wrapper']" +
                "//li[@class='page-5']/a"));
        SalesStocks.click();
        driver.findElement(By.xpath("//div[@id='footer-wrapper']" +
                "//ul[@class='list-horizontal']/li[text()=' » Скидки и акции']"));

        System.out.println("Open page Акции и скидки");
    }

    @Test
    public static  void testActionsOnPage() throws InterruptedException {
        openRubberDucks();
        WebElement icon = driver.findElement(By.xpath("//img[@alt='Subcategory']"));

        icon.click();

//        Actions builder = new Actions(driver);
//        builder.doubleClick(icon).perform();

        driver.findElement(By.xpath("//div[@id='footer-wrapper']" +
                "//ul[@class='list-horizontal']/li[text()=' » Subcategory']"));
        driver.findElement(By.xpath("//h1[@class='title'][text()='Subcategory']"));
    }

    @Test
    public static void openSubcategory() {

        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement rubberDucks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[@id='page-wrapper']//div[@id='site-menu-wrapper']//ul/li[@class='category-1']/a")));
        action.moveToElement(rubberDucks).perform();
        WebElement subcategoryMainMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//ul/li[@class='category-2']/a")));
        action.moveToElement(subcategoryMainMenu).perform();
        action.click().perform();
        WebElement subcategoryTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                        ("//h1[@class='title'][text()='Subcategory']")));

        driver.findElement(By.xpath("//h1[@class='title'][text()='Subcategory']"));
    }
}
