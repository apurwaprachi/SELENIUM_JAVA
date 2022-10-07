

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\apulnu\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net");
        WebElement logo = driver.findElement(By.xpath("div[@class='logo']"));
        WebElement home = driver.findElement(By.xpath("a[@title='home']"));
        WebElement flights = driver.findElement(By.xpath("a[@mame='flights']"));
        WebElement tour = driver.findElement(By.xpath("a[@name='Tours']"));
        WebElement Company = driver.findElement(By.xpath("a[@name='Company']"));
        WebElement signup_btn = driver.findElement(By.xpath("a[@name='Signup']"));
        WebElement login_btn = driver.findElement(By.xpath("a[@name='Login']"));
        WebElement agents_dropdown = driver.findElement(By.xpath("button[@id='agents']"));

    }
}
