package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RahulAcademy {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://rahulshettyacademy.com/locatorspractice/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.id("inputUsername")).sendKeys("hello");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademys");
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); //interuption (transition is there in the page)
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
//        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
//        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9987542189");
        driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        //div[@class= 'forgot-pwd-btn-conainer']//descendant::button
        //div[@class= 'forgot-pwd-btn-conainer']/button[1]
        driver.findElement(By.xpath("//div[@class= 'forgot-pwd-btn-conainer']//descendant::button")).click();
        Thread.sleep(1000);

//Again going back to login
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#chkboxOne")).click();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[contains(@class, 'signInBtn')]")).click();


    }
}
