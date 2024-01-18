package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AssignmentWait1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("rahulshettyacademy ");
        driver.findElement(By.name("password")).sendKeys("learning");
        driver.findElement(By.xpath("//*[@class='form-check-inline']/label/span[text()=' User']")).click();
//      driver.findElement(By.xpath("(//input[@id='usertype'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(8000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select = new Select(dropDown);
        select.selectByValue("consult");

        driver.findElement(By.name("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

    }
}
