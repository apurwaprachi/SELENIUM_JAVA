import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class BankManagerLogin extends TestBaseClass {

    File file =    new File("C:\\Users\\apulnu\\Downloads\\Test1.xlsx");

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);
    Workbook wb = new XSSFWorkbook(inputStream);

    public BankManagerLogin() throws IOException {
    }

    @Test
    private  void AddCustomer() throws Exception {

        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
        String fn = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(0));
        driver.findElement(By.xpath("//input[@ng-model='fName']")).sendKeys(fn);
        String ln = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(1));
        driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys(ln);
        String code = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(2));
        driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys(code);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
        TestBaseClass.takeSnapShot("c://Addcustomer.png");
    }
    @Test
    private static void OpenAccount() throws Exception {

        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[@ng-click='openAccount()']")).click();
        Select select=new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
        select.selectByIndex(1);
        Select select1=new Select(driver.findElement(By.xpath("//select[@name='currency']")));
        select1.selectByIndex(3);
        TestBaseClass.takeSnapShot("c://opencustomer.png");
    }
  }

