import com.google.common.base.Verify;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SampleTest extends BaseClass {
    @Test
    private static void launchurl(){
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }
    @Test
    private static void login() throws IOException {
        File file = new File(".\\UsersList.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheetAt(0);
        HSSFRow row1=sheet.getRow(1);
        HSSFCell cell = row1.getCell(0);
        String user = cell.getStringCellValue();
        HSSFRow row2=sheet.getRow(1);
        HSSFCell cell1 = row2.getCell(1);
        String password = cell1.getStringCellValue();
        launchurl();
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
    @Test
    private static void product() throws IOException{
        List<WebElement> list_of_products = driver.findElements(By.xpath("//*[@class='inventory_list']"));
        List<WebElement> list_of_products_price = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));

        String product_name;
        String product_price;
        int int_product_price;
        HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        for(int i=0;i<list_of_products.size();i++) {
            product_name = list_of_products.get(i).getText();
            product_price = list_of_products_price.get(i).getText();
            product_price = product_price.replaceAll("[^0-9]", "");
            int_product_price = Integer.parseInt(product_price);
            map_final_products.put(int_product_price, product_name);
        }
        Set<Integer> allkeys = map_final_products.keySet();
        ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
        Collections.sort(array_list_values_product_prices);
        int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
        int low_price = array_list_values_product_prices.get(0);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        String count = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }
    @Test
    public  static  void productCheckout() throws IOException {
        File file1 = new File(".\\Checkoutdetails.xls");
        FileInputStream inputStream = new FileInputStream(file1);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet1=wb.getSheetAt(0);
        HSSFRow row1 = sheet1.getRow(1);
        HSSFCell cell1 = row1.getCell(0);
        String firstName = cell1.getStringCellValue();
        HSSFRow row2 = sheet1.getRow(1);
        HSSFCell cell2 = row1.getCell(1);
        String lastName = cell2.getStringCellValue();
        HSSFRow row3 = sheet1.getRow(1);
        HSSFCell cell3 = row1.getCell(2);
        double zip = cell3.getNumericCellValue();


        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(String.valueOf(zip));

        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }
}
