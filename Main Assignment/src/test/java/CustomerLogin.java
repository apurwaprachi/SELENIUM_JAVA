import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomerLogin extends TestBaseClass {
    File file =  new File("C:\\Users\\apulnu\\Downloads\\Test1.xlsx");

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);
    Workbook wb = new XSSFWorkbook(inputStream);

    public CustomerLogin() throws IOException {

    }

    @Test(priority = 1)
    private  void deposit() throws Exception {
        driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();
        Select select2=new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
        select2.selectByIndex(1);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
        String deposit_amount = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(3));
        driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(deposit_amount);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String Confirm = driver.findElement(By.xpath("//span[text()='Deposit Successful']")).getText();
        System.out.println(Confirm);
        //Verification
        if (Confirm.equals("Deposit Successful"))
            System.out.println("Deposit Successfully");
        else
            System.out.println("Deposit Failed");

        TestBaseClass.takeSnapShot("c://deposit.png");


    }
    @Test(priority = 2)
    private  void Withdrawl() throws Exception {
        driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();
        Select select3=new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
        select3.selectByIndex(1);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        String withdrawl_amount = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(4));
        driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(withdrawl_amount);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String Confirm = driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
        System.out.println(Confirm);
        String orgconfirmmsg = "Transaction successful";
        //Verification
        if (Confirm.equals(orgconfirmmsg))
            System.out.println("Transaction Successfully");
        else
            System.out.println("Transaction Failed");
        //Verification
        TestBaseClass.takeSnapShot("c://withdrwal.png");
    }
    @Test(priority = 3)
    private  void ErrorMessageCheck() throws Exception {
        driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();
        Select select2=new Select(driver.findElement(By.xpath("//select[@name='userSelect']")));
        select2.selectByIndex(1);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        String withdrawl_amount = String.valueOf(wb.getSheetAt(0).getRow(1).getCell(5));
        driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(withdrawl_amount);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String errormessage = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        System.out.println(errormessage );
        String orginalerrormessage="Transaction Failed. You can not withdraw amount more than the balance.";

        //Verification
        if (errormessage.equals( orginalerrormessage))
            System.out.println("Pass");
        else
            System.out.println("Fail");
        TestBaseClass.takeSnapShot("c://errormessage.png");
    }



}

