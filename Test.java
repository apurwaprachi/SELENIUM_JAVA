import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Test implements ITestListener {


    @Test
    public void logindemo(){

        System.setProperty("webdriver.ie.driver", "C:\\Users\\apulnu\\Chrome Browser./server/IEDriverServer.exe");

        WebDriver driver=new ChromeDriver();
        driver.get(“https://www.saucedemo.com/”);
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("problem_user");
        driver.findElement(By.id("wronglocator")).sendKeys("dont-tell");
        driver.findElement(By.id("loginbutton")).click();
    }




    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {

        System.out.println("Screen shot captured====="+arg0.toString());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub


    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("TestCase started====" +arg0.toString());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

        System.out.println("Congrates Testcase has been passed===="+ arg0.toString());

    }

}

==========

        xml file:

        !DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" parallel="none">
<listeners>
<listener class-name="testngDemo.Test"/>
</listeners>
<test name="Test">
<classes>
<class name="testngDemo.Test"/>
</classes>
</test> <!-- Test -->
</suite> <!-- Suite -->