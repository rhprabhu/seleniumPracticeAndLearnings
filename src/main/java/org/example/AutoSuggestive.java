package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//        driver.manage().window().maximize();
//        driver.findElement(By.id("autocomplete")).sendKeys("ind");
//        Thread.sleep(2000);
//
//        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//
//        for (WebElement option : options) {
//            if (option.getText().equalsIgnoreCase("India")) {
//                option.click();
//                break;
//            }
//        }

        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(3000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).getAttribute("value");
    }
}
