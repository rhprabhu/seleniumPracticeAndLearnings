package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class TableExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> addTable = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (int i = 0; i < addTable.size(); i++) {
            sum = sum + Integer.parseInt(addTable.get(i).getText());

        }
        System.out.println(sum);

        System.out.println(driver.findElement(By.className("totalAmount")).getText());

        int actualText = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        System.out.println(actualText);

        Assert.assertEquals(sum, actualText);
        if (sum == actualText) {
            System.out.println(" sum is equal");
        } else {
            System.out.println("Sum is not equal");
        }


//        second table

        List<WebElement> table2 = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

        int sum1 = 0;
        for (int i = 0; i < table2.size(); i++) {
            sum1 = sum1 + Integer.parseInt(table2.get(i).getText());
            System.out.println(sum1);
        }

        System.out.println(driver.findElements(By.xpath("//table[@class= 'table-display']/descendant::tr")).size());
        System.out.println(driver.findElements(By.xpath("//table[@class= 'table-display']/descendant::th")).size());

        List<WebElement> rowDetail = driver.findElements(By.xpath("//table[@class= 'table-display']/descendant::tr"));
        System.out.println(rowDetail.get(2).getText());
        System.out.println(rowDetail.get(0).getText());


    }
}
