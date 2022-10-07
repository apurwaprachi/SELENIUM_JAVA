import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Provider;
import java.util.logging.Logger;

public class Myclass {
    static Logger log = Logger.getLogger(Myclass.class);
    public static void main(String[] args) {
        Provider PropertyConfigurator;
        PropertyConfigurator.configure("path\\to\\log4j.properties");
        System.setProperty("webdriver.chrome.driver", "Path\\to\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("url");
        log.info("Open url");
        driver.manage().window().maximize();
        log.info("Maximize window size");
        js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
        log.info("enter username");
        js.executeScript("document.getElementById('user_password').value='password';");
        log.info("enter password");
        js.executeScript("document.getElementById('user_submit').click();");
        log.info("click on login");
        driver.close();

    }
}