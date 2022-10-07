import com.google.common.base.Verify;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class TestCase {
    @Test

// Here this parameters we will take from testng.xml
    @Parameters("Browser")
    public  void test1(String browser) {

        if(browser.equalsIgnoreCase("FF")){
            System.setProperty("webdriver.chrome.driver", “.Path” of browser exe);


            WebDriver driver=new chromeDriver();

            driver.manage().window().maximize();

            driver.get(“https://www.saucedemo.com”);

            driver.quit();

        }
        else if(browser.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver", "./server/IEDriverServer.exe");

            WebDriver driver=new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(“https://www.saucedemo.com”);

            driver.quit();
        }
    }

}

    XML file:

<suite name="Suite" parallel="tests" thread-count="2">

<test name="Test">

<parameter name="Browser" value="FF" />

<classes>

<class name="SampleTestcases.TestCase1"/>

</classes>

</test>

<test name="Test1">

<parameter name="Browser" value="IE" />

<classes>

<class name="SampleTestcases.TestCase1"/>

</classes>

</test>

</suite>
