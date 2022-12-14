import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @BeforeTest
    public static WebDriver initialSetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\apulnu\\Chrome Browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return driver;
    }
    @AfterTest
    public static void closeBrowser(){
        driver.close();
    }
}
