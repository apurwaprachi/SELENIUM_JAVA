import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\apulnu\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net");
        WebElement checkin = driver.findElement(By.id("//input[@class='checkin form-control form-control-lg border-top-r0']");
        WebElement checkout = driver.findElement(By.id("//input[@class='checkout form-control form-control-lg border-top-l0']");
        WebElement adultDec = driver.findElement(By.id("//div[@class='dropdown-menu dropdown-menu-wrap']//div[@class='dropdown-item'][2]//i[@class='la la-minus']");
        WebElement adultInc = driver.findElement(By.id("//div[@class='dropdown-menu dropdown-menu-wrap']//div[@class='dropdown-item'][2]//i[@class='la la-plus']");
        WebElement childPlus = driver.findElement(By.id("//div[@class='dropdown-menu dropdown-menu-wrap']//div[@class='dropdown-item'][3]//i[@class='la la-plus']");
        WebElement childminus = driver.findElement(By.id("//div[@class='dropdown-menu dropdown-menu-wrap']//div[@class='dropdown-item'][3]//i[@class='la la-minus']"));
    }
}
