package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverWithAmazon {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com/");
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.className("accountInner"));
        //moves to specific element
        action.moveToElement(move).contextClick().build().perform();


        action.moveToElement(driver.findElement(By.id("inputValEnter"))).click().keyDown(Keys.SHIFT).sendKeys("bags").doubleClick().build().perform();
//driver.findElement(By.className(".searchformButton.col-xs-4.rippleGrey")).click();


    }
}
