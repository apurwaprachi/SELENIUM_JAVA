import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseClass {
    public static WebDriver driver;

    @BeforeMethod
    public static WebDriver initialSetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\apulnu\\Chrome Browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        //Create an object of File class to open xlsx file

        //File file =    new File("C:\\Users\\apulnu\\Downloads\\Test1.xlsx");

        //Create an object of FileInputStream class to read excel file

        //FileInputStream inputStream = new FileInputStream(file);
        //Workbook wb = new XSSFWorkbook(inputStream);

        return driver;
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }

    public static void takeSnapShot(String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }


}
