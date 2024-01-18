package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumWebDriver {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().window().minimize();
        String URL = "https://www.saucedemo.com/";
        driver.get(URL);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
//        System.out.println( driver.findElement(By.cssSelector("svg.fa-times")).getText());
        System.out.println("Login Successfull");
//        driver.close();
    }
}
