package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;

public class End2EndUIPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[contains(text(),'Bengaluru (BLR)')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PAT']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);

        }

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.cssSelector(".buttonN")).click();

        WebElement option = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(option);
        select.selectByValue("AED");


        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();

        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

    }
}
